package dataStructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * The type Int binary tree.
 */
public class IntBinaryTree {

    private Node root;

    private long length;

    /**
     * Insert.
     *
     * @param data the data
     */
    public void insert(int data) {
        if (root == null) {
            root = new Node(data);
        } else {
            root.insert(data);
        }
        length++;
    }

    /**
     * Is exist boolean.
     *
     * @param data the data
     * @return the boolean
     */
    public boolean isExist(int data) {
        return root.isExist(data);
    }

    /**
     * Print.
     */
    public void print() {
        if (root != null) {
            root.print();
        }
    }

    public long getLength() {
        return length;
    }

    public List<Integer> getLevelByLevel() {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            list.add(node.data);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        return list;
    }

    public void printAsInOrder() {
        printAsInOrder(root);
    }

    private void printAsInOrder(Node node) {
        if (node == null) {
            return;
        }
        printAsInOrder(node.left);
        System.out.println(node.data);
        printAsInOrder(node.right);
    }

    public void printAsPreOrder() {
        printAsPreOrder(root);
    }

    private void printAsPreOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data);
        printAsPreOrder(node.left);
        printAsPreOrder(node.right);
    }

    public void printAsPostOrder() {
        printAsPostOrder(root);
    }

    private void printAsPostOrder(Node node) {
        if (node == null) {
            return;
        }
        printAsPostOrder(node.left);
        printAsPostOrder(node.right);
        System.out.println(node.data);
    }

    public void printAtLevel(int level) {
        printAtLevel(root, level);
    }

    private void printAtLevel(Node node, int level) {
        if (node == null) {
            return;
        }
        if (level == 1) {
            System.out.println(node.data);
            return;
        }
        printAtLevel(node.left, level - 1);
        printAtLevel(node.right, level - 1);
    }

    private static class Node {

        private int data;
        private Node left;
        private Node right;

        /**
         * Instantiates a new Node.
         *
         * @param data the data
         */
        Node(int data) {
            this.data = data;
        }

        /**
         * Insert.
         *
         * @param data the data
         */
        void insert(int data) {
            if (data <= this.data) {
                if (this.left == null) {
                    this.left = new Node(data);
                } else {
                    this.left.insert(data);
                }
            } else {
                if (this.right == null) {
                    this.right = new Node(data);
                } else {
                    this.right.insert(data);
                }
            }
        }

        /**
         * Print.
         */
        void print() {
            if (this.left != null) {
                this.left.print();
            }
            System.out.println(this.data);
            if (this.right != null) {
                this.right.print();
            }
        }

        /**
         * Is exist boolean.
         *
         * @param data the data
         * @return the boolean
         */
        boolean isExist(int data) {
            if (data == this.data) {
                return true;
            }
            if (data < this.data) {
                if (this.left == null) {
                    return false;
                }
                return this.left.isExist(data);
            } else {
                if (this.right == null) {
                    return false;
                }
                return this.right.isExist(data);
            }
        }

        @Override
        public String toString() {
            return "" + data;
        }
    }

}
