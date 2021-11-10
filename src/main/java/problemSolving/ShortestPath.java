package problemSolving;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Shortest path.
 */
public class ShortestPath {

    /**
     * Find minimum cost for path.
     *
     * @param nodes  the nodes
     * @param costs  the costs
     * @param start  the start
     * @param target the target
     * @return the int
     */
    public static int find(char[] nodes, int[][] costs, char start, char target) {
        return find(nodes, costs, start, target, 0, new ArrayList<>());
    }

    /**
     * The Minimum cost.
     */
    static Integer minimumCost = Integer.MAX_VALUE;
    /**
     * The Visited nodes result.
     */
    static List<Character> visitedNodesResult = null;

    private static int find(char[] nodes, int[][] costs, char currentNode, char targetNode, Integer currentCost, List<Character> visitedNodes) {
        visitedNodes.add(currentNode);
        if (currentNode == targetNode) {
            if (currentCost < minimumCost) {
                minimumCost = currentCost;
                visitedNodesResult = visitedNodes;
                System.out.println(minimumCost + "---" + visitedNodes);
            }
        }
        int[] paths = costs[getIndexOf(nodes, currentNode)];
        for (int i = 0; i < paths.length; i++) {
            if (nodes[i] != currentNode && paths[i] != -1 && !visitedNodes.contains(nodes[i])) {
                find(nodes, costs, nodes[i], targetNode, currentCost + paths[i], new ArrayList<>(visitedNodes));
            }
        }
        return minimumCost;
    }

    private static int getIndexOf(char[] nodes, char node) {
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] == node) {
                return i;
            }
        }
        return -1;
    }

}
