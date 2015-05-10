package de.berlin.kata.conflictingObjectives;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Logger;

public class ReadableComposedWordFinder {
    private final static Logger log = Logger.getLogger(ReadableComposedWordFinder.class.getName());
    private WordLoader wordLoader = new WordLoader();


    public Set<String> getComposedWords() {
        Set<String> composedWords = new LinkedHashSet<>();
        Set<String> words = wordLoader.getWords(6);
        words.forEach(word -> {
            if (isComposedWord(word)) {
                composedWords.add(word);
            }
        });

        return composedWords;
    }

    private boolean isComposedWord(String word) {
        for (int index = 1; index <= word.length() - 1; index++) {
            String firstWord = word.substring(0, index);
            String secondWord = word.substring(index);

            if (isWordExist(firstWord) && isWordExist(secondWord)) {
                log.fine("Found composed word: " + word + " = " + firstWord + " + " + secondWord);
                return true;
            }
        }
        return false;
    }

    private boolean isWordExist(String word) {
        Set<String> words = wordLoader.getWords(word.length());
        return words.contains(word);
    }


}