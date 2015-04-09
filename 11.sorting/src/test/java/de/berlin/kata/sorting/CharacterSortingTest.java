package de.berlin.kata.sorting;

import org.junit.Assert;
import org.junit.Test;

public class CharacterSortingTest {
    private static final String inputText = "When not studying nuclear physics, Bambi likes to play\n" +
            "beach volleyball.";
    private static final String expectedOutputText = "aaaaabbbbcccdeeeeeghhhiiiiklllllllmnnnnooopprsssstttuuvwyyyy";

    @Test
    public void testSortingCharacters() {
        Assert.assertEquals(expectedOutputText, new CharacterSorting().sort(inputText));
    }

    @Test
    public void testQuickSortingCharacters() {
        Assert.assertEquals(expectedOutputText, new CharacterQuickSorting().sort(inputText));
    }
}
