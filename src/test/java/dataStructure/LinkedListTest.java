package dataStructure;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

public class LinkedListTest {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Starting LinkedListTest...");
    }

    @Test
    public void append() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.append("A");
        linkedList.append("B");
        linkedList.append("C");
        linkedList.append("D");

        assertEquals(linkedList.getSize(), 4);
    }

    @Test
    public void prepend() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.prepend("-A");
        linkedList.prepend("-B");
        linkedList.prepend("-C");

        assertEquals(linkedList.getSize(), 3);
    }

    @Test
    public void delete() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.append("A");
        linkedList.append("B");
        linkedList.append("C");
        linkedList.append("D");
        linkedList.deleteNode("D");

        assertEquals(linkedList.getSize(), 3);
    }

    @Test(expected = NoSuchElementException.class)
    public void deleteNoSuchElement() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.append("A");
        linkedList.append("B");

        linkedList.deleteNode("X");
    }

    @Test
    public void getIndex() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.append("A");
        linkedList.append("B");
        linkedList.append("C");
        linkedList.append("D");

        assertEquals(linkedList.getIndex(0), "A");
        assertEquals(linkedList.getIndex(1), "B");
        assertEquals(linkedList.getIndex(2), "C");
        assertEquals(linkedList.getIndex(3), "D");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getIndexOutOfBoundsByEmpty() {
        LinkedList<String> linkedList = new LinkedList<>();

        linkedList.getIndex(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getIndexOutOfBounds() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.append("A");
        linkedList.append("B");
        linkedList.append("C");
        linkedList.append("D");

        linkedList.getIndex(5);
    }


    @AfterClass
    public static void afterClass() {
        System.out.println("Ending LinkedListTest...");
    }
}
