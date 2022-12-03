package algorithm.sort;

/**
 * The type Insertion sort.
 * Depends on holding a number (arr[currentIndexToSort]) and compare it with all previous numbers,
 * and swap numbers if this number is less than anyone of them and proceed till the first of the array
 */
public class InsertionSort {

    /**
     * Sort int [ ].
     *
     * @param arr the arr to be sorted
     * @return the int [ ] sorted array
     */
    public static int[] sort(int[] arr) {
        if (arr == null) {
            return null;
        }
        for (int i = 1; i < arr.length; i++) {
            int index = i; //  1
            int currentIndexToSort = i; // 1
            while (index >= 0) {
                if (arr[currentIndexToSort] < arr[index]) {
                    swap(arr, currentIndexToSort, index);
                    currentIndexToSort--;
                }
                index--;
            }
        }
        return arr;
    }

    private static void swap(int[] arr, int x, int y) {
        int num = arr[x];
        arr[x] = arr[y];
        arr[y] = num;
    }
}
