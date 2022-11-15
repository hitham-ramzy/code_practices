package algorithm.search;

/**
 * The type Binary search.
 */
public class BinarySearch {

    /**
     * Search integer.
     *
     * @param array the array
     * @param item  the item
     * @return the integer
     */
    public static Integer search(int[] array, int item) {
        if (array == null) {
            return null;
        }
//        return searchRecursive(array, 0, array.length - 1, item);
        return searchByIteration(array, item);
    }

    private static Integer searchRecursive(int[] array, int start, int end, int item) {
        if (array.length == 0 || item < array[0] || item > array[array.length - 1]) {
            return null;
        }
        int midIndex = (end + start) / 2;
        Integer midItem = array[midIndex];
        if (midItem.equals(item)) {
            return midIndex;
        } else if (midItem > item) {
            return searchRecursive(array, start, midIndex, item);
        } else if (midIndex < item) {
            return searchRecursive(array, midIndex + 1, end, item);
        }
        return null;
    }

    private static Integer searchByIteration(int[] array, int item) {
        int startIndex = 0;
        int endIndex = array.length - 1;
        while (startIndex <= endIndex) {
            int midIndex = startIndex + ((endIndex - startIndex) / 2);
            int mindValue = array[midIndex];
            if (item == mindValue) {
                return midIndex;
            } else if (item < mindValue) {
                endIndex = midIndex - 1;
            } else {
                startIndex = midIndex + 1;
            }
        }
        return null;
    }
}
