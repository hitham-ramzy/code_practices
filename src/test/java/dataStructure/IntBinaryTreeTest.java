package dataStructure;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

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


    @AfterClass
    public static void afterClass() {
        System.out.println("Starting IntBinaryTreeTest...");
    }
}
