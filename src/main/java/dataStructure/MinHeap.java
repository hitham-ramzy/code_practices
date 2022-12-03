package dataStructure;

import java.util.Arrays;

/**
 * The type Min heap.
 * Usually used in sorting items
 * Java has the PriorityQueue as an implementation of the heaps
 */
public class MinHeap {
    private static final int INITIAL_ARRAY_CAPACITY = 20;
    private static int size = 0;
    private static Integer[] data = new Integer[INITIAL_ARRAY_CAPACITY];


    private static int getParentIndex(int childIndex) {
        return childIndex % 2 == 1 ? childIndex / 2 : childIndex / 2 - 1;
    }

    private static Integer getParentValue(int childIndex) {
        int parentIndex = getParentIndex(childIndex);
        if (parentIndex < 0) {
            return null;
        }
        return data[parentIndex];
    }

    private static int getLeftChildIndex(int parentIndex) {
        return parentIndex * 2 + 1;
    }

    private static Integer getLeftChildValue(int parentIndex) {
        int leftChildIndex = getLeftChildIndex(parentIndex);
        if (leftChildIndex >= size) {
            return null;
        }
        return data[leftChildIndex];
    }

    private static int getRightChildIndex(int parentIndex) {
        return parentIndex * 2 + 2;
    }

    private static Integer getRightChildValue(int parent) {
        int rightChildIndex = getRightChildIndex(parent);
        if (rightChildIndex >= size) {
            return null;
        }
        return data[rightChildIndex];
    }

    private static void checkCapacity() {
        if (size >= data.length) {
            data = Arrays.copyOf(data, data.length * 2);
        }
    }

    public static int peak() {
        return data[0];
    }

    public static int poll() {
        Integer value = data[0];
        data[0] = data[size - 1];
        data[size - 1] = null;
        size--;
        heapifyDown();
        return value;
    }

    public static void add(int value) {
        checkCapacity();
        data[size] = value;
        size++;
        heapifyUp();
    }

    private static void heapifyUp() {
        int index = size - 1;
        while (index > 0) {
            int parentIndex = getParentIndex(index);
            Integer parentValue = getParentValue(index);
            if (parentValue == null || data[index] >= parentValue) {
                return;
            }
            swap(index, parentIndex);
            index = parentIndex;
        }
    }

    private static void heapifyDown() {
        int index = 0;
        while (index < size) {
            int minimumChildIndex = getLeftChildIndex(index);
            Integer leftChildValue = getLeftChildValue(index);
            if (leftChildValue == null) {
                return;
            }

            Integer rightChildValue = getRightChildValue(index);
            if (rightChildValue != null && rightChildValue < leftChildValue) {
                minimumChildIndex = getRightChildIndex(index);
            }
            swap(index, minimumChildIndex);
            index = minimumChildIndex;
        }
    }

    private static void swap(int index1, int index2) {
        Integer tmpValue = data[index1];
        data[index1] = data[index2];
        data[index2] = tmpValue;
    }

}
