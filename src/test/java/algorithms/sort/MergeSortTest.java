package algorithms.sort;

import algorithm.sort.MergeSort;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class MergeSortTest {

    @Test
    public void sort() {
        int[] arr = {14, 33, 27, 10, 35, 19, 42, 44};
        int[] sortedArray = MergeSort.sort(arr);
        assertEquals(10, sortedArray[0]);
        assertEquals(14, sortedArray[1]);
        assertEquals(19, sortedArray[2]);
        assertEquals(27, sortedArray[3]);
        assertEquals(42, sortedArray[arr.length - 2]);
        assertEquals(44, sortedArray[arr.length - 1]);
    }

    /**
     * Sort array.
     */
    @Test
    public void sortArray() {
        int[] array = {6, 7, 3, 2, 5, 7, 9, 0, 5, 3, 2, 1};
        int[] sortedArray = {0, 1, 2, 2, 3, 3, 5, 5, 6, 7, 7, 9};
        assertArrayEquals(sortedArray, MergeSort.sort(array));
    }

    /**
     * Sort null array.
     */
    @Test
    public void sortNullArray() {
        assertNull(MergeSort.sort(null));
    }

    /**
     * Sort empty array.
     */
    @Test
    public void sortEmptyArray() {
        int[] array = {};
        assertArrayEquals(array, MergeSort.sort(array));
    }

    /**
     * Sort sorted array.
     */
    @Test
    public void sortSortedArray() {
        int[] sortedArray = {0, 1, 2, 2, 3, 3, 5, 5, 6, 7, 7, 9};
        assertArrayEquals(sortedArray, MergeSort.sort(sortedArray));
    }
}
