package de.berlin.kata.wordChains;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

public class WordLoader {

    private final static Logger LOGGER = Logger.getLogger(WordLoader.class.getName());

    public static final String WORD_LIST_FILE_NAME = "wordlist.txt";
    public static final Charset WORD_LIST_FILE_ENCODING = Charset.forName("ISO-8859-1");

    public Set<String> getWords() {
        return getWords(0);
    }


    /**
     *
     * returns
     * - wordLength > 0 => the set of the words from the file with the given wordLength
     * - wordLength == 0 => all words
     * - wordLength < 0 => IllegalArgumentException
     */
    public Set<String> getWords(int wordLength) {
        if (wordLength < 0) {
            throw new IllegalArgumentException("Argument: wordLength must be bigger than 0");
        }

        Path wordListPath = getWordListPath();

        Set<String> words = new HashSet<>();
        if (wordListPath != null) {
            try {
                String line;
                BufferedReader reader = Files.newBufferedReader(wordListPath, WORD_LIST_FILE_ENCODING);
                while ((line = reader.readLine()) != null) {
                    if (wordLength == 0) {
                        words.add(line);
                    } else if (line.length() == wordLength) {
                        words.add(line);
                    }
                }
            } catch (IOException e) {
                throw new IllegalStateException("Error while reading the file: wordlist.txt ! ERROR:" + e.getMessage());
            }
        } else {
            throw new IllegalStateException("'Unable to get the file: wordlist.txt");
        }
        return words;
    }

    public Path getWordListPath() {
        URL wordListUrl = WordLoader.class.getClassLoader().getResource(WORD_LIST_FILE_NAME);
        if (wordListUrl != null) {
            try {
                return Paths.get(wordListUrl.toURI());
            } catch (URISyntaxException e) {
                LOGGER.severe("Error while getting the file: " + WORD_LIST_FILE_NAME + " ! ERROR:" + e.getMessage());
            }
        }
        return null;
    }


}
