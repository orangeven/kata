package de.berlin.kata.sorting;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weng
 *         created: 08.04.15 - 16:13
 */
public class CharacterQuickSorting {

    private static List<Character> asciiList = createAsciiList();

    public static String sort(String text) {
        String lowerText = text.toLowerCase();
        String result = "";

        for (Character character : asciiList) {
            int occurrence = countOccurrence(lowerText, character);
            result += getMatchedText(character, occurrence);
        }
        return result;
    }

    private static String getMatchedText(Character character, int occurrence) {
        String result = "";
        for (int i = 0; i < occurrence; i++) {
            result += character;
        }
        return result;
    }

    private static List<Character> createAsciiList() {
        List<Character> ascii = new ArrayList<>(26);

        for (char c = 'a'; c <= 'z'; c++) {
            ascii.add(c);
        }
        return ascii;
    }

    private static int countOccurrence(String text, Character charToSearch) {
        return (int) text.chars().filter(charCode -> charCode == charToSearch).count();
    }
}
