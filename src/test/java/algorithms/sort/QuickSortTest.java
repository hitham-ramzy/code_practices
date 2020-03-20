package algorithms.sort;

import algorithm.sort.QuickSort;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;

public class QuickSortTest {

    @Test
    public void sort() {
        int[] array = {9, 2, 6, 4, 3, 5, 1};
        int[] sortedArray = {1, 2, 3, 4, 5, 6, 9};
        assertArrayEquals(sortedArray, QuickSort.sort(array));
    }

    /**
     * Sort null array.
     */
    @Test
    public void sortNullArray() {
        assertNull(QuickSort.sort(null));
    }

    /**
     * Sort empty array.
     */
    @Test
    public void sortEmptyArray() {
        int[] array = {};
        assertArrayEquals(array, QuickSort.sort(array));
    }

    /**
     * Sort sorted array.
     */
    @Test
    public void sortSortedArray() {
        int[] sortedArray = {0, 1, 2, 2, 3, 3, 5, 5, 6, 7, 7, 9};
        assertArrayEquals(sortedArray, QuickSort.sort(sortedArray));
    }
}
