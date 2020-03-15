package algorithm.sort;

public class InsertionSort {

    public static int[] sort(int[] arr) {
        if (arr == null) {
            return null;
        }
        // loop on array 0->arr.length-1
        for (int i = 1; i < arr.length; i++) {
            int sortingLength, index;
            sortingLength = index = i;
            // while sortLength is not equals zero
            while (sortingLength >= 0) {
                // if arr[index]< arr[sortingLength]
                if (arr[index] < arr[sortingLength]) {
                    // swap & index --;
                    swap(arr, index, sortingLength);
                    index--;
                }
                // end if
                // sortingLength--;
                sortingLength--;
            }
            // end while
        }
        // end loop
        return arr;
    }

    private static void swap(int[] arr, int x, int y) {
        int num = arr[x];
        arr[x] = arr[y];
        arr[y] = num;
    }
}
