package algorithms.sort;

import algorithm.sort.InsertionSort;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class InsertionSortTest {

    @Test
    public void sortNull() {
        assertNull(InsertionSort.sort(null));
    }

    @Test
    public void sortEmpty() {
        int[] sortedArray = InsertionSort.sort(new int[]{});
        assertEquals(sortedArray.length, 0);
    }

    @Test
    public void sort() {
        int[] arr = {14, 33, 27, 10, 35, 19, 42, 44};
        int[] sortedArray = InsertionSort.sort(arr);
        assertEquals(10, sortedArray[0]);
        assertEquals(14, sortedArray[1]);
        assertEquals(19, sortedArray[2]);
        assertEquals(27, sortedArray[3]);
        assertEquals(42, sortedArray[arr.length - 2]);
        assertEquals(44, sortedArray[arr.length - 1]);
    }
}
