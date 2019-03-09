package dataStructure;

import java.util.NoSuchElementException;

public class IntQueue {

    private int[] data;
    private int size, capacity;

    public IntQueue(int size) {
        this.size = size;
        data = new int[size];
    }

    public void enqueue(int i) {
        checkSize();
        data[capacity] = i;
        capacity++;
    }

    public int pop() {
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        return data[0];
    }

    public int dequeue() {
        int result = pop();
        shiftOne();
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

    private void shiftOne() {
        System.arraycopy(data, 1, data, 0, data.length-1);
        capacity--;
    }
}
