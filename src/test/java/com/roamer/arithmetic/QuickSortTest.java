package com.roamer.arithmetic;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class QuickSortTest {

    @Test
    public void sort() {
        int[] array = new int[]{54, 22, 87, 5, 124, 342, 48};
        QuickSort quickSort = new QuickSort(array);
        quickSort.sort();
        assertArrayEquals(new int[]{5, 22, 48, 54, 87, 124, 342}, array);
    }
}