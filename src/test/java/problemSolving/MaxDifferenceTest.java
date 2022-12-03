package problemSolving;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.util.List;

public class MaxDifferenceTest {

    @Test
    public void maxDiffTest() {
        int actual = MaxDifference.findMinimumDifference(List.of(2, 3, 10, 6, 4, 8, 1));
        assertEquals(8, actual);
    }

}