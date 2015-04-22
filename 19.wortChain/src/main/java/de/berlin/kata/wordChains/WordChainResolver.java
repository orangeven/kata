package de.berlin.kata.wordChains;

import java.util.Set;

public class WordChainResolver {

    WordLoader wordLoader = new WordLoader();
    WordChainGraph graph;

    public String resolve(String startWord, String endWord) {
        Set<String> words = wordLoader.getWords(startWord.length());
        graph = new WordChainGraph(words);
        return graph.getBestPath(startWord, endWord);
    }


    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        WordChainResolver wordChainResolver = new WordChainResolver();
        System.out.println(wordChainResolver.resolve("cat", "dog"));
        System.out.println("took time: "+ (System.currentTimeMillis() - start) + "ms");

        start = System.currentTimeMillis();
        System.out.println(wordChainResolver.resolve("lead", "gold"));
        System.out.println("took time: "+ (System.currentTimeMillis() - start) + "ms");

        start = System.currentTimeMillis();
        System.out.println(wordChainResolver.resolve("ruby", "code"));
        System.out.println("took time: " + (System.currentTimeMillis() - start) + "ms");
    }
}
