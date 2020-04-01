package dataStructure;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class IntBinaryTreeTest {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Starting IntBinaryTreeTest...");
    }

    @Test
    public void insert() {
        IntBinaryTree binaryTree = new IntBinaryTree();
        binaryTree.insert(1);
        binaryTree.insert(2);
        binaryTree.insert(-1);
        binaryTree.insert(5);
        binaryTree.insert(4);
    }

    @Test
    public void print() {
        IntBinaryTree binaryTree = new IntBinaryTree();
        binaryTree.insert(1);
        binaryTree.insert(2);
        binaryTree.insert(-1);
        binaryTree.insert(5);
        binaryTree.insert(4);
        binaryTree.print();
    }

    @Test
    public void isExist() {
        IntBinaryTree binaryTree = new IntBinaryTree();
        binaryTree.insert(1);
        binaryTree.insert(2);
        binaryTree.insert(-1);
        binaryTree.insert(5);
        binaryTree.insert(4);
        assertTrue(binaryTree.isExist(1));
        assertTrue(binaryTree.isExist(-1));
        assertTrue(binaryTree.isExist(4));
        assertFalse(binaryTree.isExist(10));
        assertFalse(binaryTree.isExist(20));
    }

    @Test
    public void length() {
        IntBinaryTree binaryTree = new IntBinaryTree();
        assertEquals(binaryTree.getLength(), 0);
        binaryTree.insert(1);
        binaryTree.insert(2);
        binaryTree.insert(-1);
        assertEquals(binaryTree.getLength(), 3);
        binaryTree.insert(5);
        binaryTree.insert(4);
        assertEquals(binaryTree.getLength(), 5);
    }

    @Test
    public void getLevelByLevel() {
        IntBinaryTree binaryTree = new IntBinaryTree();
        binaryTree.insert(1);
        binaryTree.insert(2);
        binaryTree.insert(-1);
        binaryTree.insert(5);
        binaryTree.insert(4);
        List<Integer> integerList = binaryTree.getLevelByLevel();
        assertEquals(5, integerList.size());
        assertEquals(1, integerList.get(0).intValue());
        assertEquals(-1, integerList.get(1).intValue());
        assertEquals(2, integerList.get(2).intValue());
        assertEquals(5, integerList.get(3).intValue());
        assertEquals(4, integerList.get(4).intValue());
    }

    @Test
    public void printAsInOrder() throws IOException {
        IntBinaryTree binaryTree = new IntBinaryTree();
        binaryTree.insert(1);
        binaryTree.insert(2);
        binaryTree.insert(-1);
        binaryTree.insert(5);
        binaryTree.insert(4);
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bo));
        binaryTree.printAsInOrder();
        bo.flush();
        String allWrittenLines = new String(bo.toByteArray());
        assertEquals("-1\n1\n2\n4\n5\n",allWrittenLines);
    }

    @Test
    public void printAsPreOrder() throws IOException {
        IntBinaryTree binaryTree = new IntBinaryTree();
        binaryTree.insert(1);
        binaryTree.insert(2);
        binaryTree.insert(-1);
        binaryTree.insert(5);
        binaryTree.insert(4);
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bo));
        binaryTree.printAsPreOrder();
        bo.flush();
        String allWrittenLines = new String(bo.toByteArray());
        assertEquals("1\n-1\n2\n5\n4\n",allWrittenLines);
    }

    @Test
    public void printAsPostOrder() throws IOException {
        IntBinaryTree binaryTree = new IntBinaryTree();
        binaryTree.insert(1);
        binaryTree.insert(2);
        binaryTree.insert(-1);
        binaryTree.insert(5);
        binaryTree.insert(4);
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bo));
        binaryTree.printAsPostOrder();
        bo.flush();
        String allWrittenLines = new String(bo.toByteArray());
        assertEquals("-1\n4\n5\n2\n1\n",allWrittenLines);
    }

    @Test
    public void printAtLevel() throws IOException {
        IntBinaryTree binaryTree = new IntBinaryTree();
        binaryTree.insert(1);
        binaryTree.insert(2);
        binaryTree.insert(-1);
        binaryTree.insert(5);
        binaryTree.insert(4);
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bo));
        binaryTree.printAtLevel(2);
        bo.flush();
        String allWrittenLines = new String(bo.toByteArray());
        assertEquals("-1\n2\n",allWrittenLines);
    }


    @AfterClass
    public static void afterClass() {
        System.out.println("Starting IntBinaryTreeTest...");
    }
}
