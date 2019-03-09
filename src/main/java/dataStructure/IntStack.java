package dataStructure;

import java.util.NoSuchElementException;

public class IntStack {

    private int[] data;
    private int size, capacity;

    public IntStack(int size) {
        this.size = size;
        this.data = new int[size];
    }

    public void push(int i) {
        checkSize();
        data[capacity] = i;
        capacity++;
    }

    public int peak() {
        if (capacity == 0) {
            throw new NoSuchElementException();
        }
        return data[capacity - 1];
    }

    public int pop() {
        int result = peak();
        capacity--;
        return result;
    }

    public long getSize() {
        return size;
    }

    public long getCapacity() {
        return capacity;
    }

    public boolean isEmpty() {
        return capacity == 0;
    }

    /*
    This method duplicate the array size if the capacity equals the array size
    */
    private void checkSize() {
        if (capacity == data.length) {
            int[] newData = new int[data.length * 2];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
            size *= 2;
        }
    }
}
