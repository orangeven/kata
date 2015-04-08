package de.berlin.kata.sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author weng
 *         created: 08.04.15 - 16:06
 */
public class SortedList<T> {

    private List<T> list = new ArrayList<>();
    private Comparator<T> comparator;

    public SortedList(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public void add(T element) {
        list.add(getPosition(element), element);
    }

    private int getPosition(T newElement) {
        int index = 0;
        for (T element : list) {
            if (comparator.compare(element, newElement) > 0) {
                break;
            } else {
                index++;
            }
        }
        return index;
    }

    public List<T> getList() {
        return this.list;
    }

}
