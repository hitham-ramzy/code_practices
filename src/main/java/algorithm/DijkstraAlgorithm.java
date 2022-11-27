package algorithm;

public class DijkstraAlgorithm {


    public static char[] findShortestPath(char[] nodes, int[][] costs, int indexOfStartNode) {

        char[] usedIndexes = new char[nodes.length];
        int[][] shortPathMatrix = new int[nodes.length][nodes.length];

        int currentIndex = indexOfStartNode;
        int currentNodeCost = 0;
        for (int row = 0; row < nodes.length; row++) {
            for (int column = 0; column < nodes.length; column++) {
                if (currentIndex == column || isUsedBefore(nodes[column], usedIndexes)) {
                    shortPathMatrix[row][column] = 0;
                } else if (row == nodes.length - 1 && shortPathMatrix[row - 1][column] != 0) {
                    shortPathMatrix[row][column] = shortPathMatrix[row - 1][column];
                } else {
                    int stepCost = costs[currentIndex][column] != -1 ? costs[currentIndex][column] : Integer.MAX_VALUE;
                    stepCost = stepCost == Integer.MAX_VALUE ? stepCost : stepCost + currentNodeCost;

                    int previousCost = row == 0 || shortPathMatrix[row - 1][column] == -1 ? Integer.MAX_VALUE : shortPathMatrix[row - 1][column];

                    int minimumStepCost = Math.min(stepCost, previousCost);
                    minimumStepCost = minimumStepCost == Integer.MAX_VALUE ? -1 : minimumStepCost;
                    shortPathMatrix[row][column] = minimumStepCost;
                }
            }
            usedIndexes[row] = nodes[currentIndex];
            if (row != nodes.length - 1) {
                currentIndex = getSmallestIndex(shortPathMatrix[row]);
                currentNodeCost = shortPathMatrix[row][currentIndex];
            }
//            drawMatrix(shortPathMatrix);
        }
        return usedIndexes;
    }

    private static int getSmallestIndex(int[] indexes) {
        int smallestIndex = Integer.MAX_VALUE;
        int smallestValue = Integer.MAX_VALUE;
        for (int i = 0; i < indexes.length; i++) {
            if (indexes[i] < smallestValue && indexes[i] > 0) {
                smallestIndex = i;
                smallestValue = indexes[i];
            }
        }
        return smallestIndex;
    }

    private static boolean isUsedBefore(char c, char[] usedIndexes) {
        for (char i : usedIndexes) {
            if (i == c) {
                return true;
            }
        }
        return false;
    }

    private static void drawMatrix(int[][] ma) {

        for (int[] row : ma) {
            for (int i : row) {
                System.out.print("" + i + " ");
            }
            System.out.println("");
        }

        System.out.println("--------");
    }

}
