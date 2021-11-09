package problemSolving;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;

public class IceCreamParlorTest {

    @Test
    public void getIceCreamIndices_sample() {
        int[] result = IceCreamParlor.getIceCreamIndices(new int[]{10, 2, 4, 6, 1, 6, 8}, 12);
        assertNotNull(result);
        assertEquals(1, result[0]);
        assertEquals(0, result[1]);
    }

    @Test
    public void getIceCreamIndices_sample2() {
        int[] result = IceCreamParlor.getIceCreamIndices(new int[]{2, 6, 1, 6, 8, 4}, 12);
        assertNotNull(result);
        assertEquals(5, result[0]);
        assertEquals(4, result[1]);
    }

    @Test
    public void getIceCreamIndices_duplicatePriceCase() {
        int[] result = IceCreamParlor.getIceCreamIndices(new int[]{2, 6, 1, 6, 8}, 12);
        assertNull(result);
    }
}
