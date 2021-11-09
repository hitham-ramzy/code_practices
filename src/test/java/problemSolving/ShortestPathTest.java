package problemSolving;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ShortestPathTest {
    @Test
    public void findShortestPath() {
        char[] nodes = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
        int[][] costs = {
                {0, 8, 2, 5, -1, -1, -1, -1},
                {8, 0, -1, 2, -1, 13, -1, -1},
                {2, -1, 0, 2, 5, -1, -1, -1},
                {5, 2, 2, 0, 1, 6, 3, -1},
                {-1, -1, 5, 1, 0, -1, 1, -1},
                {-1, 13, -1, 6, -1, 0, 2, 3},
                {-1, -1, -1, 3, 1, 2, 0, 6},
                {-1, -1, -1, -1, -1, 3, 6, 0}
        };

        assertEquals(11, ShortestPath.find(nodes, costs, 'A', 'H'));
    }
}
