package algorithm.sort;

public class QuickSort {
    public static int[] sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        sort(arr, 0, arr.length - 1);
        return arr;
    }

    public static void sort(int[] arr, int start, int end) {
        // check start > end return;
        if (start >= end) {
            return;
        }
        // get partition
        int partition = partition(arr, start, end);

        // sort stat -> partition
        sort(arr, start, partition);

        // sort partition -> end
        sort(arr, partition + 1, end);
    }

    private static int partition(int[] arr, int start, int end) {
        // get PIVOT value
        int pivotIndex = (start + end) / 2;
        int pivot = arr[pivotIndex];

        // while start < end
        while (start < end) {
            // get x value > PIVOT starting from start to end
            while (start < arr.length && arr[start] < pivot) {
                start++;
                if (start == pivotIndex) {
                    start++;
                }
            }

            // get y value < PIVOT starting from end to start
            while (end >= 0 && arr[end] > pivot) {
                end--;
                if (end == pivotIndex) {
                    end--;
                }
            }

            // swap x and y
            if (start < arr.length && end >= 0 && start < end) {
                swap(arr, start, end);
                start++;
                end--;
            }
        }
        // end while

        return pivotIndex;
    }

    private static void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index2];
        arr[index2] = arr[index1];
        arr[index1] = tmp;
    }

}
