package problemSolving;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class MaxConflictedTimeSlotsTest {

    @Test
    public void testConflictedSlots() {
        long[] startArray = {1481122000, 1481122000, 1481122030, new Date().getTime()};
        long[] endArray = {1481122020, 1481122035, 1481122040, new Date().getTime() + 1000};
        assertEquals(2, MaxConflictedTimeSlots.howManyAgentsToAdd(startArray, endArray));
    }
}
