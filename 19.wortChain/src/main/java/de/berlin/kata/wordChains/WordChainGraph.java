package de.berlin.kata.wordChains;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by quan on 16.04.15.
 */
public class WordChainGraph {
    private Set<Node> wordNodes;

    ITransitionRule transitionRule = new WordChainTransitionRule();
    private Map<Node, Set<Node>> transitions = new HashMap<>();

    public WordChainGraph(Set<String> words) {
        wordNodes = createWordNodes(words);
        createTransitions(wordNodes);
    }

    public String getBestPath(String startWord, String endWord) {
        resetNodeWeights();

        Set<Node> visitedNodes = new HashSet<>();
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(new Node(startWord));


        while (!nodeQueue.isEmpty()) {
            Node parentNode = nodeQueue.peek();
            visitedNodes.add(parentNode);
            Set<Node> nextNodes = transitions.get(parentNode);
            if (nextNodes != null) {
//                nodeQueue.addAll(nextNodes);
                for (Node nextNode : nextNodes) {
                    if(!visitedNodes.contains(nextNode)) {
                        nextNode.setPreviousNode(parentNode);
                        visitedNodes.add(nextNode) ;

                    }
                }
            }
        }



        /*
        get next nodes

        nextNodes.setParent if not yet visited

        nextNodes.removeVisitedNodes


         */

        return "";
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
        Map<Integer, Set<Node>> nodeLengthMap = wordNodes.stream().collect(Collectors.groupingBy(word -> word.getValue().length(), Collectors.toSet()));
        return new ArrayList<>(nodeLengthMap.values());
    }

    private Set<Node> createTransitionFromNode(Node startNode, Set<Node> subNodes) {
        //TODO name
        Set<Node> transitionNodes = new LinkedHashSet<>();
        for (Node node2 : subNodes) {
            if (!startNode.equals(node2) && transitionRule.hasTransition(startNode, node2)) {
                transitionNodes.add(node2);
            }
        }
        return transitionNodes;
    }

//    private Set<Node> getWordsWithLength(final int wordLength) {
//        return wordNodes.stream().filter(node -> wordLength == node.getValue().length()).collect(Collectors.toSet());
//    }

    public Set<Node> getNextNodes(Node node) {
        return transitions.get(node);
    }

}
