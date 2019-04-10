package algorithms;

import algorithm.BubbleSort;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;

/**
 * The type Bubble sort test.
 */
public class BubbleSortTest {

    /**
     * Sort array.
     */
    @Test
    public void sortArray() {
        int[] array = {6, 7, 3, 2, 5, 7, 9, 0, 5, 3, 2, 1};
        int[] sortedArray = {0, 1, 2, 2, 3, 3, 5, 5, 6, 7, 7, 9};
        assertArrayEquals(sortedArray, BubbleSort.sort(array));
    }

    /**
     * Sort null array.
     */
    @Test
    public void sortNullArray() {
        assertNull(BubbleSort.sort(null));
    }

    /**
     * Sort empty array.
     */
    @Test
    public void sortEmptyArray() {
        int[] array = {};
        assertArrayEquals(array, BubbleSort.sort(array));
    }

    /**
     * Sort sorted array.
     */
    @Test
    public void sortSortedArray() {
        int[] sortedArray = {0, 1, 2, 2, 3, 3, 5, 5, 6, 7, 7, 9};
        assertArrayEquals(sortedArray, BubbleSort.sort(sortedArray));
    }
}
