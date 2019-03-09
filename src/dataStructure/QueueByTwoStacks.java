package dataStructure;

import java.util.NoSuchElementException;
import java.util.Stack;

public class QueueByTwoStacks<T> {

    private Stack<T> firstStack = new Stack<>();
    private Stack<T> secondStack = new Stack<>();

    public void enqueue(T t) {
        firstStack.push(t);
    }

    public T peek() {
        checkSize();
        moveToSecondStack();
        T result = secondStack.peek();
        moveToFirstStack();
        return result;
    }

    public T dequeue() {
        checkSize();
        moveToSecondStack();
        T result = secondStack.pop();
        moveToFirstStack();
        return result;
    }

    private void checkSize() {
        if (firstStack.isEmpty()) {
            throw new NoSuchElementException();
        }
    }

    private void moveToFirstStack() {
        for (T t : secondStack) {
            firstStack.push(t);
        }
    }

    private void moveToSecondStack() {
        for (T t : firstStack) {
            secondStack.push(t);
        }
    }

}
