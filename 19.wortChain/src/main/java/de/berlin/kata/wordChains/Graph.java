package de.berlin.kata.wordChains;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by quan on 16.04.15.
 */
public class Graph {
    Set nodes;
//    Set<Transition> transitions;
    Node startNode;
    Node endeNode;
    Map<Node, Set<Node>> transitions  = new HashMap<>();

    public Set<Transition> createTransitions(Node start, Set<Node> nodes){
        return null;
    }

    public Set<Node> getNextNodes(Node node) {
        return transitions.get(node);
    }

}
