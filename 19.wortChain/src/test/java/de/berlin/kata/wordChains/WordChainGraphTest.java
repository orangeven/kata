package de.berlin.kata.wordChains;

import junit.framework.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class WordChainGraphTest {

    private List<String> words = Arrays.asList("cat", "dog", "cot", "cog", "CAA", "CBB", "CID", "cod");

    @Test
    public void testGetBestWordChainForCatAndDog() {
        String startWord = "cat";
        String endWord = "dog";

        Assert.assertEquals("cat, cot, cog, dog", new WordChainGraph(new HashSet<>(words)).getBestPath(startWord, endWord));
    }

    @Test(expected = IllegalArgumentException.class)
    public void lengthOfStartWordAndEndWordShouldBeTheSame() {
        new WordChainGraph(new HashSet<>(words)).getBestPath("ab", "a");
    }

    @Test(expected = IllegalArgumentException.class)
    public void startWordShouldNotBeBlank() {
        new WordChainGraph(new HashSet<>(words)).getBestPath("", "a");
    }

    @Test(expected = IllegalArgumentException.class)
    public void endWordShouldNotBeBlank() {
        new WordChainGraph(new HashSet<>(words)).getBestPath("ab", "");
    }

    @Test
    public void emptyStringShouldBeReturnedIfStartWordDoesNotExistInTheWordList() {
        Assert.assertEquals("", new WordChainGraph(new HashSet<>(words)).getBestPath("ab", "ba"));
    }
}
