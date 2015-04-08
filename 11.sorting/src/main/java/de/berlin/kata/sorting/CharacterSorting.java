package de.berlin.kata.sorting;

import java.util.stream.Collectors;

public class CharacterSorting {

    private static SortedList<Character> characters  = new SortedList<>((c1,c2)-> c1 - c2);


    public static String sort(String text){
        String normalizedText = normalizeText(text);

        for(Character element: normalizedText.toCharArray()) {
            characters.add(element);
        }
        return characters.getList().stream().map(i-> String.valueOf(i)).collect(Collectors.joining(""));
    }

    private static String normalizeText(String text) {
        return text.replaceAll("[^a-zA-Z]", "").toLowerCase();
    }
}


