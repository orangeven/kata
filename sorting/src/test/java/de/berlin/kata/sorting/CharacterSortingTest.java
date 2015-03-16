package de.berlin.kata.sorting;

import org.junit.Assert;
import org.junit.Test;

public class CharacterSortingTest {

    @Test
    public void testSortingCharacters() {
        String inputText = "When not studying nuclear physics, Bambi likes to play\n" +
                "beach volleyball.";
        String expectedOutputText = "aaaaabbbbcccdeeeeeghhhiiiiklllllllmnnnnooopprsssstttuuvwyyyy";
        CharacterSorting characterSorting = new CharacterSorting();
        Assert.assertEquals(expectedOutputText, characterSorting.sort(inputText));
    }
}
