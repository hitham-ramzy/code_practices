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
                lastNode = lastNode.getNext();
            }
            lastNode.setNext(new Node<>(nodeData));
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
            firstNode.setNext(oldFirstNode);
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
            if (nodeBeforeDelete.getNext().getData() != null && nodeBeforeDelete.getNext().getData().equals(nodeData)) {
                break;
            }
            nodeBeforeDelete = nodeBeforeDelete.getNext();
        }
        if (nodeBeforeDelete.getNext() == null || !nodeBeforeDelete.getNext().getData().equals(nodeData)) {
            throw new NoSuchElementException();
        }
        nodeBeforeDelete.setNext(nodeBeforeDelete.getNext().getNext());
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
                return resultNode.getData();
            }
            resultNode = resultNode.getNext();
            loopIndex++;
        }
        throw new NoSuchElementException();
    }
}

class Node<T> {

    private T data;
    private Node<T> next;

    Node(T data) {
        this.data = data;
    }

    T getData() {
        return data;
    }

    Node<T> getNext() {
        return next;
    }

    void setNext(Node<T> next) {
        this.next = next;
    }

    boolean hasNext() {
        return next != null;
    }
}
