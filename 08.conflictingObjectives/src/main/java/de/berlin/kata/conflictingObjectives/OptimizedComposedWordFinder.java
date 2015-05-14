package de.berlin.kata.conflictingObjectives;

import org.apache.commons.lang.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.logging.Logger;

public class OptimizedComposedWordFinder {
    private final static Logger log = Logger.getLogger(ReadableComposedWordFinder.class.getName());
    private WordLoader wordLoader = new WordLoader();
    // Map of WordLength and Words
    private Map<Integer, Set<String>> wordMap;

    public Set<String> getComposedWords() {
        wordMap = wordLoader.getWords(new HashSet<>(Arrays.asList(1,2,3,4,5,6)));
        Set<String> composedWords = new HashSet<>();

        Set<String> wordsWith6Length = wordMap.get(6);
        for (String word : wordsWith6Length) {
            if (isComposedWord(word)) {
                composedWords.add(word);
            }
        }

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
        Set<String> words = wordMap.get(word.length());
        return words.contains(word);
    }
}
