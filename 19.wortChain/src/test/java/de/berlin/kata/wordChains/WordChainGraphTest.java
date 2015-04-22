package de.berlin.kata.wordChains;

import junit.framework.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class WordChainGraphTest {

    @Test
    public void testGetBestWordChainForCatAndDog(){
        String startWord = "cat";
        String endWord = "dog";
        List<String> words =Arrays.asList("cat", "dog", "cot","cog", "CAA", "CBB", "CID", "cod");

        Assert.assertEquals("cat, cot, cog, dog", new WordChainGraph(new HashSet<>(words)).getBestPath(startWord, endWord));
    }
}
