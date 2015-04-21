package de.berlin.kata.wordChains;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by quan on 16.04.15.
 */
public class WordChainResolver {

    WordService wordService;
    WordChainGraph graph;

    public void resolve(String startWord, String endWord) {
        Set<String> words = wordService.getWords(startWord.length());
//        words.remove(startWord);

        Set<Node> nodes = words.stream().map(Node::new).collect(Collectors.toSet());

        // build the graph. create all transations
//        Set<Transition> transitions = new HashSet<>();
//        for (Node node : nodes) {
//            transitions.addAll(nodeService.createTransitions(node, nodes));
//        }

        // print transitions

        // find the paths
        Node startNode = new Node(startWord);
        Set<Node> nextNodes = graph.getNextNodes(startNode);

//        for(Transition transition: nextNodes) {
//            Node toNode = transition.to;
//            toNode.setVisited(true);
//            toNode.setWeigh(1);
//        }



//        return null;

    }
}
