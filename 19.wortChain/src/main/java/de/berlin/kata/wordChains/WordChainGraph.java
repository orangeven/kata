package de.berlin.kata.wordChains;

import org.apache.commons.lang.StringUtils;

import java.util.*;
import java.util.stream.Collectors;


public class WordChainGraph {
    private Set<Node> wordNodes;

    ITransitionRule transitionRule = new WordChainTransitionRule();
    private Map<Node, Set<Node>> transitions = new HashMap<>();

    public WordChainGraph(Set<String> words) {
        Set<String> lowerCaseWords = new LinkedHashSet<>();
        words.stream().forEach(word -> {
            lowerCaseWords.add(word.toLowerCase());
        });

        wordNodes = createWordNodes(lowerCaseWords);
        createTransitions(wordNodes);
    }

    public String getBestPath(String startWord, String endWord) {
        if (StringUtils.isBlank(startWord) || StringUtils.isBlank(endWord)) {
            throw new IllegalArgumentException("startWord and endWord must not be null or blank!");
        } else if (startWord.length() != endWord.length()) {
            throw new IllegalArgumentException("length of startWord and endWord must be the same!");
        } else if (!wordNodes.contains(new Node(startWord)) || !wordNodes.contains(new Node(endWord))) {
            return "";
        }

        resetNodeWeights();

        Set<Node> visitedNodes = new HashSet<>();
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(new Node(startWord.toLowerCase()));
        Node endNode = null;

        while (!nodeQueue.isEmpty()) {
            Node currentNode = nodeQueue.remove();

            Set<Node> childNodes = getUnvisitedChildNodes(currentNode, visitedNodes);

            for (Node childNode : childNodes) {
                childNode.setParentNode(currentNode);
                if (!nodeQueue.contains(childNode)) {
                    nodeQueue.add(childNode);
                }
            }

            visitedNodes.add(currentNode);
            if (currentNode.getValue().equals(endWord)) {
                endNode = currentNode;
            }
        }

        List<Node> bestPath = getBestPath(endNode);
        return bestPath.stream().map(Node::getValue).collect(Collectors.joining(", "));
    }

    private Set<Node> getUnvisitedChildNodes(Node currentNode, Set<Node> visitedNodes) {
        Set<Node> childNodes = transitions.get(currentNode);
        if (childNodes != null) {
            childNodes.removeAll(visitedNodes);
        } else {
            childNodes = new LinkedHashSet<>();
        }
        return childNodes;
    }

    private List<Node> getBestPath(Node endNode) {
        List<Node> bestPath = new ArrayList<>();
        if (endNode != null) {
            bestPath.add(endNode);
            Node parentNode;
            while ((parentNode = endNode.getParentNode()) != null) {
                bestPath.add(parentNode);
                endNode = parentNode;
            }
            Collections.reverse(bestPath);
        }
        return bestPath;
    }

    private void resetNodeWeights() {
        wordNodes.stream().forEach(Node::reset);
    }

    private Set<Node> createWordNodes(Set<String> words) {
        return words.stream().map(Node::new).collect(Collectors.toSet());
    }

    private void createTransitions(Set<Node> wordNodes) {
        List<Set<Node>> groupedNodes = groupNodesByLength(wordNodes);

        for (Set<Node> nodeSubSet : groupedNodes) {
            for (Node node : nodeSubSet) {
                Set<Node> transitionNodes = createTransitionFromNode(node, nodeSubSet);
                transitions.put(node, transitionNodes);
            }
        }
    }

    private List<Set<Node>> groupNodesByLength(Set<Node> wordNodes) {
        Map<Integer, Set<Node>> nodeLengthMap = wordNodes.stream()
                .collect(Collectors.groupingBy(word -> word.getValue().length(), Collectors.toSet()));
        return new ArrayList<>(nodeLengthMap.values());
    }

    private Set<Node> createTransitionFromNode(Node parentNode, Set<Node> subNodes) {
        Set<Node> childNodes = new LinkedHashSet<>();
        for (Node childNode : subNodes) {
            if (!parentNode.equals(childNode) && transitionRule.hasTransition(parentNode, childNode)) {
                childNodes.add(childNode);
            }
        }
        return childNodes;
    }
}
