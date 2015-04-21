package de.berlin.kata.wordChains;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by quan on 16.04.15.
 */
public class WordChainGraph {
    private Set<Node> nodes;
    private Node startNode;
    private Node endNode;

    private Map<Node, Set<Node>> transitions = new HashMap<>();

    public WordChainGraph(Set<String> words) {
        nodes = words.stream().map(Node::new).collect(Collectors.toSet());
        createTransitions();
    }

    private void createTransitions() {
        int nodeNumber = nodes.size();
        int processedNodeNumber = 0;

        for (int wordLength = 1; processedNodeNumber != nodeNumber; ) {
            Set<Node> nodesWithLength = getWordsWithLength(wordLength);
            processedNodeNumber += nodesWithLength.size();

            for (Node node : nodesWithLength) {
                Set<Node> transitionNodes = createTransitionFromNode(node, nodesWithLength);
                transitions.put(node, transitionNodes);
            }
        }
    }

    private Set<Node> createTransitionFromNode(Node startNode, Set<Node> subNodes) {
        //TODO name
        Set<Node> transitionNodes = new LinkedHashSet<>();
        for (Node node2 : subNodes) {
            if (!startNode.equals(node2) && WordChainTransitionRule.isTransitionPossible(startNode, node2)) {
                transitionNodes.add(node2);
            }
        }
        return transitionNodes;
    }

    private Set<Node> getWordsWithLength(final int wordLength) {
        return nodes.stream().filter(n -> wordLength == n.getValue().length()).collect(Collectors.toSet());
    }

    public Set<Node> getNextNodes(Node node) {
        return transitions.get(node);
    }

}
