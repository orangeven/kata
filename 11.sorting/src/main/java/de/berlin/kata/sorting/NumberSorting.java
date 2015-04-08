package de.berlin.kata.sorting;

import java.util.List;

class NumberSorting {

    private SortedList<Integer> numbers = new SortedList<>((number1, number2) -> number1 - number2);

    public List<Integer> getSortedNumbers() {
        return numbers.getList();
    }

    public void addNumber(Integer newNumber) {
        numbers.add(newNumber);
    }

}