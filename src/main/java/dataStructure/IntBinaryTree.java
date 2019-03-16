package dataStructure;

import java.util.*;
import java.util.LinkedList;

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

    private class Node {

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
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }

}