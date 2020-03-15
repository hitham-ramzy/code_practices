package algorithm.sort;

/**
 * The type Bubble sort.
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
