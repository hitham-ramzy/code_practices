package algorithms.search;

import algorithm.search.BinarySearch;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * The type Binary search test.
 */
public class BinarySearchTest {

    /**
     * Search in empty.
     */
    @Test
    public void searchInEmpty() {
        int[] array = new int[0];
        Integer index = BinarySearch.search(array, 2);
        assertNull(index);
    }

    /**
     * Search in null.
     */
    @Test
    public void searchInNull() {
        assertNull(BinarySearch.search(null, 2));
    }

    /**
     * Search in list.
     */
    @Test
    public void searchInArray() {
        int[] array = {1, 2, 3, 4, 5, 7, 8, 20};
        Integer index = BinarySearch.search(array, 5);
        assertEquals(Integer.valueOf(4), index);
    }

    /**
     * Search in long list.
     */
    @Test
    public void searchInLongArray() {
        int[] array = {1, 2, 3, 4, 5, 7, 8, 20, 50, 60, 77, 80, 83, 88, 100,
                101, 102, 103, 104, 105, 107, 108, 1020, 1050, 1060, 1077, 1080, 1083, 1088, 10100};
        Integer index = BinarySearch.search(array, 108);
        assertEquals(Integer.valueOf(21), index);
    }

    /**
     * Search in long list first item.
     */
    @Test
    public void searchInLongArrayFirstItem() {
        int[] array = {1, 2, 3, 4, 5, 7, 8, 20, 50, 60, 77, 80, 83, 88, 100,
                101, 102, 103, 104, 105, 107, 108, 1020, 1050, 1060, 1077, 1080, 1083, 1088, 10100};
        Integer index = BinarySearch.search(array, 1);
        assertEquals(Integer.valueOf(0), index);
    }

    /**
     * Search in long list last item.
     */
    @Test
    public void searchInLongArrayLastItem() {
        int[] array = {1, 2, 3, 4, 5, 7, 8, 20, 50, 60, 77, 80, 83, 88, 100,
                101, 102, 103, 104, 105, 107, 108, 1020, 1050, 1060, 1077, 1080, 1083, 1088, 10100};
        Integer index = BinarySearch.search(array, 10100);
        assertEquals(Integer.valueOf(array.length - 1), index);
    }

    /**
     * Search not found.
     */
    @Test
    public void searchNotFound() {
        int[] array = {1, 2, 3, 4, 5, 7, 8, 20};
        Integer index = BinarySearch.search(array, 80);
        assertNull(index);
    }
}
