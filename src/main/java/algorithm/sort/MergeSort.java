package algorithm.sort;

public class MergeSort {

    public static int[] sort(int[] arr) {
        if (arr == null || arr.length == 0 || arr.length == 1) {
            return arr;
        }
        sort(arr, 0, arr.length - 1);
        return arr;
    }

    public static void sort(int[] arr, int start, int end) {

        if (start >= end) {
            return;
        }

        int middle = (start + end) / 2;

        // sort left
        sort(arr, start, middle);

        // sort right
        sort(arr, middle + 1, end);

        // merge the two arrays
        mergeArrays(arr, start, end);

    }

    private static void mergeArrays(int[] arr, int start, int end) {
        int[] mergedArray = new int[arr.length];
        int indexLeft = start;
        int rightStart = start + ((end - start) / 2) + 1;
        int indexRight = rightStart;

        for (int i = start; i <= end; i++) {
            if (indexRight > end || (indexLeft < rightStart && arr[indexLeft] < arr[indexRight])) {
                mergedArray[i] = arr[indexLeft];
                indexLeft++;
            } else {
                mergedArray[i] = arr[indexRight];
                indexRight++;
            }
        }
        System.arraycopy(mergedArray, start, arr, start, end - start + 1);
    }

}
