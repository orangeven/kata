package de.berlin.kata.sorting;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by Quan on 3/15/2015.
 */
public class NumberSortingTest {

    @Test
   public void testNumberSorting(){
        NumberSorting numberSorting = new NumberSorting();
        Assert.assertArrayEquals(new Integer[]{} ,  numberSorting.getSortedNumbers().toArray());

        numberSorting.addNumber(20);
        Assert.assertArrayEquals(new Integer[]{20} ,  numberSorting.getSortedNumbers().toArray());

        numberSorting.addNumber(10);
        Assert.assertArrayEquals(new Integer[]{10,20} ,  numberSorting.getSortedNumbers().toArray());

        numberSorting.addNumber(30);
        Assert.assertArrayEquals(new Integer[]{10,20,30} ,  numberSorting.getSortedNumbers().toArray());
    }
}
