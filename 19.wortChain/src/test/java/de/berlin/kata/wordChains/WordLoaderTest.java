package de.berlin.kata.wordChains;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;

import static junit.framework.Assert.assertEquals;


public class WordLoaderTest {
    private WordLoader wordLoader = new WordLoader();

    @Before
    public void createTestWords() throws IOException {
        String[] words = {"cat", "dog", "ab", "abcde"};
        Path filePath = new WordLoader().getWordListPath();
        filePath.toFile().delete();

        writeWordsToFile(words, filePath);
    }

    private void writeWordsToFile(String[] words, Path filePath) throws IOException {
        BufferedWriter writer = Files.newBufferedWriter(filePath, WordLoader.WORD_LIST_FILE_ENCODING);

        for (String word : words) {
            writer.write(word + "\n");
        }
        writer.flush();
        writer.close();
    }

    @Test
    public void testLoadWordsWithLength() {
        Set<String> words = wordLoader.getWords(3);
        assertEquals(2, words.size());
        words.forEach(word -> assertEquals(3, word.length()));
    }

    @Test
    public void testLoadAllWords() {
        Set<String> words = wordLoader.getWords(0);
        assertEquals(4, words.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalArgumentExceptionShouldBeThrownIfWordLengthIsNegative() {
        wordLoader.getWords(-1);
    }
}
