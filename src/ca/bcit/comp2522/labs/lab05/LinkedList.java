package ca.bcit.comp2522.labs.lab05;

import java.util.Objects;

/**
 * the linkedList class.
 *
 * @author keegan
 * @version 2020
 */
public class LinkedList {
    private Node head;

    /**
     * creates a linked list object.
     */
    public LinkedList() {
        head = null;
    }

    /**
     * gets the head of the list.
     * @return returns the current head
     */
    public Node getHead() {
        return head;
    }

    /**
     * sets a new head for the list.
     * @param head the new node object to become the head
     */
    public void setHead(Node head) {
        this.head = head;
    }

    /**
     * adds a node to the beginning of the list.
     * @param data the node to add to the list
     */
    public void prepend(Object data) {
        Node newHead = new Node(data);
        newHead.setNext(head);
        setHead(newHead);
    }

    /**
     * appends a node to the end of the list.
     * @param data the node to add to the list
     */
    public void append(Object data) {
        Node iterator = head;
        while (iterator.getNext() != null) {
            iterator = iterator.getNext();
        }
        Node newNode = new Node(data);
        iterator.setNext(newNode);
    }

    /**
     * gets the size of the linked list.
     * @return the count of the list
     */
    public int size() {
        int counter = 0;
        Node iterator = head;
        while (iterator.getNext() != null) {
            iterator = iterator.getNext();
            counter++;
        }
        return ++counter;
    }

    /**
     * clears the list.
     */
    public void clear() {
        head = null;
    }

    /**
     * gets the data of a specific node index.
     * @param index the index to access
     * @return returns the data of the index
     * @throws IndexOutOfBoundsException if the given index is too small or too large
     */
    public Object get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }
        Node currentNode = head;
        for (int currentIndex = 0; currentIndex < index; currentIndex++) {
            currentNode = currentNode.getNext();
        }
        return currentNode.getData();
    }

    /**
     * adds a value at a certain index.
     * @param data the value to add
     * @param index the index to add
     * @throws IndexOutOfBoundsException id the given index is too small or too large
     */
    public void add(Object data, int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > size() + 1) {
            throw new IndexOutOfBoundsException();
        }
        Node currentNode = head;
        Node previousNode = head;
        for (int currentIndex = 0; currentIndex <= index; currentIndex++) {
            if (currentIndex == index) {
                Node newNode = new Node(data);
                if (index != 0 && previousNode != null) {
                    previousNode.setNext(newNode);
                } else {
                    head = newNode;
                }
                newNode.setNext(currentNode);
            }
            previousNode = currentNode;
            if (currentNode != null) {
                currentNode = currentNode.getNext();
            }
        }
    }

    /**
     * removes an elements based on the index given.
     * @param index a given index
     * @throws IndexOutOfBoundsException if the index is too small or too large
     */
    public void remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }
        Node currentNode = head;
        Node previousNode = head;
        for (int currentIndex = 0; currentIndex <= index; currentIndex++) {
            if (currentIndex == index && index == 0) {
                head = head.getNext();
            } else if (currentIndex == index) {
                previousNode.setNext(currentNode.getNext());
                currentNode.setNext(null);
            }
            previousNode = currentNode;
            currentNode = currentNode.getNext();
        }
    }

    /**
     * creates a string object to represent the objects state.
     * @return a string object.
     */
    @Override
    public String toString() {
        return "LinkedList{"
                + "head=" + head
                + '}';
    }

    /**
     * tests if two objects are equal.
     * @param o the object to test
     * @return whether they are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LinkedList)) {
            return false;
        }
        LinkedList that = (LinkedList) o;
        return Objects.equals(getHead(), that.getHead());
    }

    /**
     * generates a hashcode for the object.
     * @return the generated hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(getHead());
    }
}
