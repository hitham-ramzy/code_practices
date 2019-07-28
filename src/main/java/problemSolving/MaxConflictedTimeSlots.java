package problemSolving;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class MaxConflictedTimeSlots {

    public static class SlotValue implements Comparable<SlotValue> {
        long value;
        boolean isStart;

        SlotValue(long value, boolean isStart) {
            this.value = value;
            this.isStart = isStart;
        }

        @Override
        public int compareTo(SlotValue o) {
            return (int) (this.value - o.value);
        }
    }

    static int howManyAgentsToAdd(long[] startArray, long[] endArray) {
        int sum = 0, max = 0;
        // defining the start time by marking as isStart = true and the end times with false
        List<SlotValue> startList = Arrays.stream(startArray).mapToObj(operand -> new SlotValue(operand, true)).collect(Collectors.toList());
        List<SlotValue> endList = Arrays.stream(endArray).mapToObj(operand -> new SlotValue(operand, false)).collect(Collectors.toList());

        // merging and sorting them
        startList.addAll(endList);
        Collections.sort(startList);

        // if the tine started then add one and save the value if it max, if the time is close them minus one
        for (Object o : startList) {
            SlotValue slotValue = (SlotValue) o;
            if (slotValue.isStart) {
                sum++;
                if (sum > max) {
                    max = sum;
                }
            } else {
                sum--;
            }
        }
        return max;
    }
}
