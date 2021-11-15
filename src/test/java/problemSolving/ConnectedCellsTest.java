package problemSolving;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ConnectedCellsTest {

    @Test
    public void findMaxConnectedCells_sample() {

        int[][] sample = {
                {0, 0, 0, 1, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0},
                {1, 1, 0, 1, 0, 0, 1},
                {0, 0, 0, 0, 0, 1, 0},
                {1, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0}
        };

        assertEquals(7, ConnectedCells.findMaxConnectedCells(sample));
    }

    @Test
    public void findMaxConnectedCells_sample2() {

        int[][] sample = {
                {0, 0, 0, 1, 1, 1, 1},
                {0, 1, 0, 0, 1, 1, 1},
                {1, 1, 0, 1, 0, 0, 1},
                {0, 0, 1, 0, 0, 1, 0},
                {1, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0}
        };

        assertEquals(16, ConnectedCells.findMaxConnectedCells(sample));
    }
}
