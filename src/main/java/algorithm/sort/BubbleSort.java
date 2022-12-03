package algorithm.sort;

/**
 * The type Bubble sort.
 * compare each item to the previous one and swap them if needed
 * and Repeat the action till you make sure all are sorted
 * There is a small enhancement here in defining the "sortTo" variable to set the limit of the loop as the last index already sorted in the previous stpes
 */
public class BubbleSort {

    /**
     * Sort int [ ].
     *
     * @param array the array
     * @return the int [ ]
     */
    public static int[] sort(int[] array) {
        if (array == null) {
            return null;
        }
        int sortTo = array.length;
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < sortTo - 1; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    isSorted = false;
                }
            }
            sortTo--;
        }
        return array;
    }

    private static void swap(int[] array, int firstIndex, int secondIndex) {
        int tempValue = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = tempValue;
    }
}
