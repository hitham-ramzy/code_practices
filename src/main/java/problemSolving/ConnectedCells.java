package problemSolving;

/**
 * The type Connected cells.
 */
public class ConnectedCells {

    /**
     * Find max connected cells.
     *
     * Return the maximum connected cells in the matrix
     *
     * Sample:
     * {
     *  {0, 0, 0, 1, 1, 0, 0},
     *  {0, 1, 0, 0, 1, 1, 0},
     *  {1, 1, 0, 1, 0, 0, 1},
     *  {0, 0, 0, 0, 0, 1, 0},
     *  {1, 1, 0, 0, 0, 0, 0},
     *  {0, 0, 0, 1, 0, 0, 0}
     * }
     *
     * Expected response is 7
     * Because there are 7 connected cells in the matrix
     *
     * @param sample the sample
     * @return the int
     */
    public static int findMaxConnectedCells(int[][] sample) {
        int maxValue = 0;
        for (int row = 0; row < sample.length; row++) {
            for (int column = 0; column < sample[row].length; column++) {
                int connectedIndices = findMaxConnectedCells(sample, row, column);
                maxValue = Math.max(maxValue, connectedIndices);
            }
        }
        return maxValue;
    }

    private static int findMaxConnectedCells(int[][] sample, int row, int column) {
        if (row < 0 || row >= sample.length || column < 0 || column >= sample[row].length || sample[row][column] == 0) {    // the skip case
            return 0;
        }
        int value = sample[row][column];
        sample[row][column] = 0;    // make it zero to avoid recalculating it.

        int sum = 0;
        for (int newRow = row - 1; newRow <= row + 1; newRow++) {
            for (int newColumn = column - 1; newColumn <= column + 1; newColumn++) {
                sum += findMaxConnectedCells(sample, newRow, newColumn);        // Do the same on the neighbor cells
            }
        }
        return sum + value; // append the value of the passed cell to the value of all neighbor cells
    }


}
