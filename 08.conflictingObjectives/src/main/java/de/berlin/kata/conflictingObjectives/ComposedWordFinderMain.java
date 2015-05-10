package de.berlin.kata.conflictingObjectives;


import java.util.Set;

public class ComposedWordFinderMain {

    public static void main(String[] a) {
        long start = System.currentTimeMillis();
        ReadableComposedWordFinder wordFinder = new ReadableComposedWordFinder();
        Set<String> words = wordFinder.getComposedWords();
        System.out.println("Readable composedWordFinder took time: " + (System.currentTimeMillis() - start) + "ms."
                + " Found " + words.size() + " composed words");

//        words.forEach(System.out::println);
    }
}
