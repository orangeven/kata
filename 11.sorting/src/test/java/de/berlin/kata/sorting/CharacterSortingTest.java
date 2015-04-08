package de.berlin.kata.sorting;

import org.junit.Assert;
import org.junit.Test;

public class CharacterSortingTest {
    private static final String inputText = "When not studying nuclear physics, Bambi likes to play\n" +
            "beach volleyball.";
    private static final String expectedOutputText = "aaaaabbbbcccdeeeeeghhhiiiiklllllllmnnnnooopprsssstttuuvwyyyy";

    @Test
    public void testQuickSortingCharacters() {
        long start = System.currentTimeMillis();
        Assert.assertEquals(expectedOutputText, CharacterQuickSorting.sort(inputText));
        System.out.println("time for quick sort: " + (System.currentTimeMillis() - start));
    }

    @Test
    public void testSortingCharacters() {
        long start = System.currentTimeMillis();
        Assert.assertEquals(expectedOutputText, CharacterSorting.sort(inputText));
        System.out.println("time for normal sort: " + (System.currentTimeMillis() - start));
    }
}
