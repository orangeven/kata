package de.berlin.kata.sorting;

import java.util.stream.Collectors;

public class CharacterSorting {

    private SortedList<Character> characters = new SortedList<>((c1, c2) -> c1 - c2);


    public String sort(String text) {
        String normalizedText = normalizeText(text);

        for (Character element : normalizedText.toCharArray()) {
            characters.add(element);
        }
        return characters.getList().stream().map(i -> String.valueOf(i)).collect(Collectors.joining(""));
    }

    private String normalizeText(String text) {
        return text.replaceAll("[^a-zA-Z]", "").toLowerCase();
    }
}


