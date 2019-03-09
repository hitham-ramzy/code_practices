package problemSolving;

import dataStructure.QueueByTwoStacks;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

public class QueueByTwoStacksTest {

    private static QueueByTwoStacks<String> emptyQueue = new QueueByTwoStacks<>();
    private static QueueByTwoStacks<String> queue = new QueueByTwoStacks<>();

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Starting QueueByTwoStacksTest...");
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        queue.enqueue("D");
        queue.enqueue("E");
    }

    @Test
    public void peak() {
        assertEquals(queue.peek(), "E");
        assertEquals(queue.peek(), "E");
        assertEquals(queue.peek(), "E");
    }

    @Test
    public void dequeue() {
        assertEquals(queue.dequeue(), "E");
        assertEquals(queue.dequeue(), "D");
        assertEquals(queue.dequeue(), "C");
    }

    @Test(expected = NoSuchElementException.class)
    public void peakEmptyQueue() {
        emptyQueue.peek();
    }

    @Test(expected = NoSuchElementException.class)
    public void dequeueEmptyQueue() {
        emptyQueue.dequeue();
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("Ending QueueByTwoStacksTest...");
    }
}
