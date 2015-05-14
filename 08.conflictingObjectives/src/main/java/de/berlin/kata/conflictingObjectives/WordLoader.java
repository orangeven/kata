package de.berlin.kata.conflictingObjectives;

import org.apache.commons.lang.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

public class WordLoader {

    private final static Logger log = Logger.getLogger(WordLoader.class.getName());
    private Map<Integer, Set<String>> cachedResult = new HashMap<>();

    public static final String WORD_LIST_FILE_NAME = "wordlist.txt";
    public static final Charset WORD_LIST_FILE_ENCODING = Charset.forName("ISO-8859-1");

    /**
     * returns
     * - wordLength > 0 => the set of the words from the file with the given wordLength
     * - wordLength == 0 => all words
     * - wordLength < 0 => IllegalArgumentException
     */
    public Set<String> getWords(int wordLength) {
        if (wordLength < 0) {
            throw new IllegalArgumentException("Argument: wordLength must be bigger than 0");
        }
        Set<String> words = cachedResult.get(wordLength);
        if (cachedResult.get(wordLength) != null) {
            return words;
        } else {
            words = new HashSet<>();
        }

        log.fine("Loading words with length:" + wordLength + " from file: " + WORD_LIST_FILE_NAME);
        Path wordListFilePath = getWordListPath();

        if (wordListFilePath != null) {
            try {
                String line;
                BufferedReader reader = Files.newBufferedReader(wordListFilePath, WORD_LIST_FILE_ENCODING);
                while ((line = reader.readLine()) != null) {
                    if (StringUtils.isNotBlank(line)) {
                        if (wordLength == 0) {
                            words.add(line);
                        } else if (line.length() == wordLength) {
                            words.add(line);
                        }
                    }
                }
            } catch (IOException e) {
                throw new IllegalStateException("Error while reading the file: wordlist.txt ! ERROR:" + e.getMessage());
            }
        } else {
            throw new IllegalStateException("'Unable to get the file: wordlist.txt");
        }

        log.info("Found " + words.size() + " words with length: " + wordLength);
        cachedResult.put(wordLength, words);
        return words;
    }

    public Map<Integer, Set<String>> getWords(Set<Integer> wordLengths) {
        if (wordLengths == null || wordLengths.isEmpty()) {
            throw new IllegalArgumentException("Argument: wordLengths is required!");
        }

        Map<Integer, Set<String>> wordMap = new HashMap<>();
        for (int i = 1; i <= 6; i++) {
            wordMap.put(i, new HashSet<>());
        }

        Path wordListFilePath = getWordListPath();

        if (wordListFilePath != null) {
            try {
                String line;
                BufferedReader reader = Files.newBufferedReader(wordListFilePath, WORD_LIST_FILE_ENCODING);
                while ((line = reader.readLine()) != null) {
                    if (StringUtils.isNotBlank(line)) {
                        if (wordLengths.contains(line.length())) {
                            wordMap.get(line.length()).add(line);
                        }
                    }
                }
            } catch (IOException e) {
                throw new IllegalStateException("Error while reading the file: wordlist.txt ! ERROR:" + e.getMessage());
            }
        } else {
            throw new IllegalStateException("'Unable to get the file: wordlist.txt");
        }

        wordMap.entrySet().forEach((entry) -> {
            log.info("Found " + entry.getValue().size() + " words with length: " + entry.getKey());
            cachedResult.put(entry.getKey(), entry.getValue());
        });
        return wordMap;
    }

    protected Path getWordListPath() {
        URL wordListUrl = WordLoader.class.getClassLoader().getResource(WORD_LIST_FILE_NAME);
        if (wordListUrl != null) {
            try {
                return Paths.get(wordListUrl.toURI());
            } catch (URISyntaxException e) {
                log.severe("Error while getting the file: " + WORD_LIST_FILE_NAME + " ! ERROR:" + e.getMessage());
            }
        }
        return null;
    }


}
