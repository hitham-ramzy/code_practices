package dataStructure;

import java.util.NoSuchElementException;

public class LinkedList<T> {

    private Node<T> firstNode;

    private long size;

    /*
     * returns the size of the linked list
     * */
    public long getSize() {
        return size;
    }

    /*
     * if there is no nodes then create the first nodeData
     * else get the last one and add this a new node into its next
     * */
    public void append(T nodeData) {
        if (firstNode == null) {
            firstNode = new Node<>(nodeData);
        } else {
            Node<T> lastNode = firstNode;
            while (lastNode.hasNext()) {
                lastNode = lastNode.next;
            }
            lastNode.next= new Node<>(nodeData);
        }
        size++;
    }

    /*
     * if there is no nodes then make this nodeData is the firstNode
     * else create a new node to be the firstNode and refer to the (old)firstNode as next
     * */
    public void prepend(T nodeData) {
        if (firstNode == null) {
            firstNode = new Node<>(nodeData);
        } else {
            Node<T> oldFirstNode = firstNode;
            firstNode = new Node<>(nodeData);
            firstNode.next = oldFirstNode;
        }
        size++;
    }

    /*
     * get the nodeData which is before the nodeData to be deleted
     * and refer to the next of the next nodeData(skip the required nodeData to delete)
     * */
    public void deleteNode(T nodeData) {
        if (firstNode == null) {
            throw new NoSuchElementException();
        }

        Node<T> nodeBeforeDelete = firstNode;
        while (nodeBeforeDelete.hasNext()) {
            if (nodeBeforeDelete.next.data != null && nodeBeforeDelete.next.data.equals(nodeData)) {
                break;
            }
            nodeBeforeDelete = nodeBeforeDelete.next;
        }
        if (nodeBeforeDelete.next == null || !nodeBeforeDelete.next.data.equals(nodeData)) {
            throw new NoSuchElementException();
        }
        nodeBeforeDelete.next = nodeBeforeDelete.next.next;
        size--;
    }

    /*
     * returns the data of the index
     * */
    public T getIndex(long index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> resultNode = firstNode;
        long loopIndex = 0;
        while (loopIndex < size) {
            if (loopIndex == index) {
                return resultNode.data;
            }
            resultNode = resultNode.next;
            loopIndex++;
        }
        throw new NoSuchElementException();
    }

    private class Node<T> {

        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }

        boolean hasNext() {
            return next != null;
        }
    }
}
