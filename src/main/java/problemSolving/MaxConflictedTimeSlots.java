package problemSolving;

import java.util.ArrayList;
import java.util.Arrays;
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

        public String toString() {
            return "" + value;
        }
    }

    static int howManyAgentsToAdd(long[] startArray, long[] endArray) {
        int sum = 0, max = 0;
        // defining the start time by marking as isStart = true and the end times with false
        List<SlotValue> startList = Arrays.stream(startArray).mapToObj(operand -> new SlotValue(operand, true)).collect(Collectors.toList());
        List<SlotValue> endList = Arrays.stream(endArray).mapToObj(operand -> new SlotValue(operand, false)).collect(Collectors.toList());

        // merging and sorting them
        List<SlotValue> mergedSlots = merge(startList, endList);

        // if the tine started then add one and save the value if it max, if the time is close them minus one
        for (Object o : mergedSlots) {
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

    private static List<SlotValue> merge(List<SlotValue> slots1, List<SlotValue> slots2) {
        int slot1Index = 0;
        int slot2Index = 0;
        int mergedArraySize = slots1.size() + slots2.size();
        List<SlotValue> mergedList = new ArrayList<>(mergedArraySize);
        for (int i = 0; i < mergedArraySize; i++) {
            if ((slot1Index < slots1.size() && slots1.get(slot1Index).value < slots2.get(slot2Index).value) || slot2Index >= slots2.size()) {
                mergedList.add(slots1.get(slot1Index));
                slot1Index++;
            } else {
                mergedList.add(slots2.get(slot2Index));
                slot2Index++;
            }
        }
        return mergedList;
    }

}
