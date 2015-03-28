package de.berlin.kata.sorting;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;


import java.util.List;

/**
 * Created by Quan on 3/15/2015.
 */
public class NumberSortingTest {
    private NumberSorting numberSorting ;

    @Before
    public void init(){
        numberSorting = new NumberSorting();   
    }

    @Test
    public void testNumbersShouldBeEmptyAtTheBeginning(){
        Assert.assertArrayEquals(new Integer[]{} ,  numberSorting.getSortedNumbers().toArray());
    }
    
    @Test
    public void testNumberSorting(){         
        numberSorting.addNumber(20);
        Assert.assertArrayEquals(new Integer[]{20} ,  numberSorting.getSortedNumbers().toArray());

        numberSorting.addNumber(10);
        Assert.assertArrayEquals(new Integer[]{10,20} ,  numberSorting.getSortedNumbers().toArray());

        numberSorting.addNumber(30);
        Assert.assertArrayEquals(new Integer[]{10,20,30} ,  numberSorting.getSortedNumbers().toArray());
    }

    @Test
    public void testAddTheSameNumber(){
        numberSorting.addNumber(20);
        Assert.assertArrayEquals(new Integer[]{20} ,  numberSorting.getSortedNumbers().toArray());

        numberSorting.addNumber(20);
        Assert.assertArrayEquals(new Integer[]{20,20} ,  numberSorting.getSortedNumbers().toArray());
    }

    @Test
    public void addNegativeNumber(){
        numberSorting.addNumber(20);
        Assert.assertArrayEquals(new Integer[]{20} ,  numberSorting.getSortedNumbers().toArray());

        numberSorting.addNumber(-10);
        Assert.assertArrayEquals(new Integer[]{-10,20} ,  numberSorting.getSortedNumbers().toArray());
    }
}