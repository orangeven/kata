package de.berlin.kata.sorting;

import java.util.*;
import java.util.stream.IntStream;

/**
 * @author weng
 *         created: 08.04.15 - 16:13
 */
public class CharacterQuickSorting {

    private static List<Character> asciiList = createAsciiList();
    private Map<Character, Integer> characterCounters;

    public String sort(String text) {
        String normalizeText = normalizeText(text);
        initCharacterCounter();
        countCharacters(normalizeText);
        return buildResultString();
    }

    private String buildResultString() {
        StringBuilder result = new StringBuilder("");
        for (Map.Entry<Character, Integer> entry : characterCounters.entrySet()) {
            Character character = entry.getKey();
            Integer count = entry.getValue();
            for (int i = 0; i < count; i++) {
                result.append(character);
            }
        }
        return result.toString();
    }

    private void countCharacters(String normalizeText) {
        normalizeText.chars().forEach(charCode -> {
            char character = (char) charCode;
            Integer count = characterCounters.get(character);
            if (count != null) {
                count++;
                characterCounters.put(character, count);
            }
        });
    }

    private void initCharacterCounter() {
        characterCounters = new LinkedHashMap<>();
        asciiList.stream().forEach(c -> characterCounters.put(c, 0));
    }

    private String normalizeText(String text) {
        return text.replaceAll("[^a-zA-Z]]", "").toLowerCase();
    }

    private static List<Character> createAsciiList() {
        List<Character> ascii = new ArrayList<>(26);

        for (char c = 'a'; c <= 'z'; c++) {
            ascii.add(c);
        }
        return ascii;
    }
}
