package de.berlin.kata.conflictingObjectives;

import org.apache.commons.lang.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

public class OptimizedComposedWordFinder {
    private final static Logger log = Logger.getLogger(ReadableComposedWordFinder.class.getName());
    private WordLoader wordLoader = new WordLoader();
    // Map of WordLength and Words
    private Map<Integer, Set<String>> wordMap = new HashMap<>();

    public Set<String> getComposedWords() {
        initWords();
        Set<String> composedWords = new HashSet<>();

        Set<String> wordsWith6Length = wordMap.get(6);
        for (String word : wordsWith6Length) {
            if (isComposedWord(word)) {
                composedWords.add(word);
            }
        }

        return composedWords;
    }

    private void initWords() {
        for (int i = 1; i <= 6; i++) {
            wordMap.put(i, new HashSet<>());
        }

        Path wordListFilePath = wordLoader.getWordListPath();
        if (wordListFilePath != null) {
            try {
                String line;
                BufferedReader reader = Files.newBufferedReader(wordListFilePath, wordLoader.WORD_LIST_FILE_ENCODING);
                while ((line = reader.readLine()) != null) {
                    if (line.length() >= 1 && line.length() <= 6) {
                        wordMap.get(line.length()).add(line);
                    }
                }
            } catch (IOException e) {
                throw new IllegalStateException("Error while reading the file: wordlist.txt ! ERROR:" + e.getMessage());
            }
        }

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
