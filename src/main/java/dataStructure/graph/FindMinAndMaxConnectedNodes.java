package dataStructure.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
        https://www.hackerrank.com/challenges/components-in-graph/problem
     * Complete the 'componentsInGraph' function below.
     *
     * function receive a list of 2D array define nodes connections
     * find the min and max connected nodes
     *
     * Sample Input
        STDIN   Function
        -----   --------
        5       bg[] size n = 5
        1 6     bg = [[1, 6],[2, 7], [3, 8], [4,9], [2, 6]]
        2 7
        3 8
        4 9
        2 6

        Sample Output
        2 4

        * because min connected nodes are 3->8 / 4->9   (2 nodes)
        * and max connected nodes are 1->6->2->7        (4 nodes)
        *
        * Node 0 or one node connected should be ignored
     */
public class FindMinAndMaxConnectedNodes {

    public static List<Integer> componentsInGraph(List<List<Integer>> gb) {
        // Write your code here
        Map<Integer, Set<Integer>> nodes = buildNodesMap(gb);
        HashSet<Integer> visitedNodes = new HashSet<>();
        int maxLinkedNodes = -1;
        int minLinkedNodes = Integer.MAX_VALUE;

        for (Integer key : nodes.keySet()) {
            int numOfLinkedNodes = getNumberOfLinkedNodesForNode(key, nodes, visitedNodes);
            if (numOfLinkedNodes > maxLinkedNodes) {
                maxLinkedNodes = numOfLinkedNodes;
            }
            if (numOfLinkedNodes < minLinkedNodes && numOfLinkedNodes > 1) {
                minLinkedNodes = numOfLinkedNodes;
            }
        }
        List<Integer> result = new ArrayList<>();
        result.add(minLinkedNodes);
        result.add(maxLinkedNodes);
        return result;
    }

    private static Map<Integer, Set<Integer>> buildNodesMap(List<List<Integer>> gb) {
        Map<Integer, Set<Integer>> nodes = new HashMap<>();
        for (List<Integer> list : gb) {
            Integer node1 = list.get(0);
            Integer node2 = list.get(1);
            if (!nodes.containsKey(node1)) {
                nodes.put(node1, new HashSet<>());
            }
            if (!nodes.containsKey(node2)) {
                nodes.put(node2, new HashSet<>());
            }
            nodes.get(node1).add(node2);
            nodes.get(node2).add(node1);
        }
        return nodes;
    }

    private static Integer getNumberOfLinkedNodesForNode(Integer currentNode, Map<Integer, Set<Integer>> nodes, HashSet<Integer> visitedNodes) {
        if (visitedNodes.contains(currentNode)) {
            return 0;
        }
        visitedNodes.add(currentNode);
        Set<Integer> children = nodes.get(currentNode);
        int countNodes = 0;
        for (Integer child : children) {
            countNodes += getNumberOfLinkedNodesForNode(child, nodes, visitedNodes);
        }
        return 1 + countNodes;
    }
}
