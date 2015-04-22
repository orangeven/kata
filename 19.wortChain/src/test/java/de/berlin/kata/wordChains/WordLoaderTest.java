package de.berlin.kata.wordChains;

import junit.framework.Assert;
import org.junit.Test;

import java.util.Set;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;


public class WordLoaderTest {

    @Test
    public void testLoadWordsWithLength() {
        Set<String> words = new WordLoader().getWords(3);
        assertTrue(words.size() > 0);
        words.forEach(word -> assertEquals(3, word.length()));
    }

    @Test
    public void testLoadAllWords() {
        Set<String> words = new WordLoader().getWords(0);
        Assert.assertTrue(words.size() > 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalArgumentExceptionShouldBeThrownIfWordLengthIsNegative(){
        new WordLoader().getWords(-1);
    }
}
