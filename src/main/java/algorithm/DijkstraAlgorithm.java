package algorithm;

public class DijkstraAlgorithm {


    public static char[] findShortestPath(char[] nodes, int[][] costs, int indexOfStartNode) {

        char[] usedIndexes = new char[nodes.length];
        int[][] shortPathMatrix = new int[nodes.length][nodes.length];

        int currentIndex = indexOfStartNode;
        int currentNodeCost = 0;
        for (int i = 0; i < nodes.length; i++) {
            for (int j = 0; j < nodes.length; j++) {
                if (currentIndex == j || isUsedBefore(nodes[j], usedIndexes)) {
                    shortPathMatrix[i][j] = 0;
                } else if (i == nodes.length - 1 && shortPathMatrix[i - 1][j] != 0) {
                    shortPathMatrix[i][j] = shortPathMatrix[i - 1][j];
                } else {
                    int stepCost = costs[currentIndex][j] != -1 ? costs[currentIndex][j] : Integer.MAX_VALUE;
                    stepCost = stepCost == Integer.MAX_VALUE ? stepCost : stepCost + currentNodeCost;

                    int previousCost = i == 0 || shortPathMatrix[i - 1][j] == -1 ? Integer.MAX_VALUE : shortPathMatrix[i - 1][j];

                    int minimumStepCost = Math.min(stepCost, previousCost);
                    minimumStepCost = minimumStepCost == Integer.MAX_VALUE ? -1 : minimumStepCost;
                    shortPathMatrix[i][j] = minimumStepCost;
                }
            }
            usedIndexes[i] = nodes[currentIndex];
            if (i != nodes.length - 1) {
                currentIndex = getSmallestIndex(shortPathMatrix[i]);
                currentNodeCost = shortPathMatrix[i][currentIndex];
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
