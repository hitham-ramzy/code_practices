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
        return search(array, 0, array.length - 1, item);
    }

    private static Integer search(int[] array, int start, int end, int item) {
        if (array.length == 0 || item < array[0] || item > array[array.length - 1]) {
            return null;
        }
        int midIndex = (end + start) / 2;
        Integer midItem = array[midIndex];
        if (midItem.equals(item)) {
            return midIndex;
        } else if (midItem > item) {
            return search(array, start, midIndex, item);
        } else if (midIndex < item) {
            return search(array, midIndex + 1, end, item);
        }
        return null;
    }
}
