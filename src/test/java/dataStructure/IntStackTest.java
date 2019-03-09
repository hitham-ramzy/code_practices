package dataStructure;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class IntStackTest {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Starting IntStackTest...");
    }

    @Test
    public void initSize(){
        IntStack intStack = new IntStack(5);
        assertEquals(intStack.getSize(), 5);
    }

    @Test
    public void initCapacity(){
        IntStack intStack = new IntStack(5);
        assertEquals(intStack.getCapacity(), 0);
    }

    @Test
    public void isEmpty(){
        IntStack intStack = new IntStack(5);
        assertTrue(intStack.isEmpty());
    }

    @Test
    public void push(){
        IntStack intStack = new IntStack(5);
        intStack.push(1);
        assertEquals(intStack.getSize(), 5);
        assertEquals(intStack.getCapacity(), 1);
    }

    @Test
    public void peak(){
        IntStack intStack = new IntStack(5);
        intStack.push(1);
        intStack.push(2);
        intStack.push(3);
        intStack.push(4);
        assertEquals(intStack.peak(), 4);
        assertEquals(intStack.getSize(), 5);
        assertEquals(intStack.getCapacity(), 4);
    }

    @Test
    public void pop(){
        IntStack intStack = new IntStack(5);
        intStack.push(1);
        intStack.push(2);
        intStack.push(3);
        intStack.push(4);
        assertEquals(intStack.pop(), 4);
        assertEquals(intStack.getSize(), 5);
        assertEquals(intStack.getCapacity(), 3);
    }

    @Test
    public void duplicateSize(){
        IntStack intStack = new IntStack(5);
        intStack.push(1);
        intStack.push(2);
        intStack.push(3);
        intStack.push(4);
        assertEquals(intStack.getCapacity(), 4);
        assertEquals(intStack.getSize(), 5);
        intStack.push(5);
        intStack.push(6);
        assertEquals(intStack.getCapacity(), 6);
        assertEquals(intStack.getSize(), 10);
        intStack.pop();
        intStack.pop();
        intStack.peak();
        assertEquals(intStack.getCapacity(), 4);
        assertEquals(intStack.getSize(), 10);
    }

    @Test(expected = NoSuchElementException.class)
    public void peakEmpty(){
        IntStack intStack = new IntStack(5);
        intStack.peak();
    }


    @AfterClass
    public static void afterClass() {
        System.out.println("Ending IntStackTest...");
    }
}
