package dataStructure;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class IntQueueTest {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Starting IntQueueTest...");
    }

    @Test
    public void initSize(){
        IntQueue intQueue = new IntQueue(5);
        assertEquals(intQueue.getSize(), 5);
    }

    @Test
    public void initCapacity(){
        IntQueue intQueue = new IntQueue(5);
        assertEquals(intQueue.getCapacity(), 0);
    }

    @Test
    public void isEmpty(){
        IntQueue intQueue = new IntQueue(5);
        assertTrue(intQueue.isEmpty());
    }

    @Test
    public void enqueue(){
        IntQueue intQueue = new IntQueue(5);
        intQueue.enqueue(1);
        assertEquals(intQueue.getSize(), 5);
        assertEquals(intQueue.getCapacity(), 1);
    }

    @Test
    public void pop(){
        IntQueue intQueue = new IntQueue(5);
        intQueue.enqueue(1);
        intQueue.enqueue(2);
        intQueue.enqueue(3);
        intQueue.enqueue(4);
        assertEquals(intQueue.pop(), 1);
        assertEquals(intQueue.getSize(), 5);
        assertEquals(intQueue.getCapacity(), 4);
    }

    @Test
    public void dequeue(){
        IntQueue intQueue = new IntQueue(5);
        intQueue.enqueue(1);
        intQueue.enqueue(2);
        intQueue.enqueue(3);
        intQueue.enqueue(4);
        assertEquals(intQueue.dequeue(), 1);
        assertEquals(intQueue.getSize(), 5);
        assertEquals(intQueue.getCapacity(), 3);
    }

    @Test
    public void duplicateSize(){
        IntQueue intQueue = new IntQueue(5);
        intQueue.enqueue(1);
        intQueue.enqueue(2);
        intQueue.enqueue(3);
        intQueue.enqueue(4);
        assertEquals(intQueue.getCapacity(), 4);
        assertEquals(intQueue.getSize(), 5);
        intQueue.enqueue(5);
        intQueue.enqueue(6);
        assertEquals(intQueue.getCapacity(), 6);
        assertEquals(intQueue.getSize(), 10);
        intQueue.dequeue();
        intQueue.dequeue();
        intQueue.pop();
        assertEquals(intQueue.getCapacity(), 4);
        assertEquals(intQueue.getSize(), 10);
    }

    @Test(expected = NoSuchElementException.class)
    public void dequeueEmpty(){
        IntQueue intQueue = new IntQueue(5);
        intQueue.dequeue();
    }


    @AfterClass
    public static void afterClass() {
        System.out.println("Ending IntQueueTest...");
    }
}
