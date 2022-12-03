package problemSolving;

import java.util.List;

/**
 * The type Max difference.
 * find the maximum difference between array items
 */
public class MaxDifference {

    public static Integer findMinimumDifference(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return null;
        }

        int minimumValue = numbers.get(0);
        int maxDiff = -1;
        for (int i = 1; i < numbers.size(); i++) {
            if ((numbers.get(i) - minimumValue) > maxDiff) {
                maxDiff = numbers.get(i) - minimumValue;
            }

            if (numbers.get(i) < minimumValue) {
                minimumValue = numbers.get(i);
            }
        }
        return maxDiff;
    }

}
