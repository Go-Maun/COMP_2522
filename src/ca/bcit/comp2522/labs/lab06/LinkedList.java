package ca.bcit.comp2522.labs.lab06;

import java.util.Objects;

/**
 * the linkedList class.
 *
 * @param <T> the type of the list.
 * @author keegan
 * @version 2020
 */
public class LinkedList<T> {
    private Node<T> head;

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
    public Node<T> getHead() {
        return head;
    }

    /**
     * sets a new head for the list.
     * @param head the new node object to become the head
     */
    public void setHead(Node<T> head) {
        this.head = head;
    }

    /**
     * adds a node to the beginning of the list.
     * @param data the node to add to the list
     */
    public void prepend(T data) {
        LinkedList.Node<T> newHead = new Node<>(data);
        newHead.setNext(head);
        setHead(newHead);
    }

    /**
     * appends a node to the end of the list.
     * @param data the node to add to the list
     */
    public void append(T data) {
        Node<T> iterator = head;
        while (iterator.getNext() != null) {
            iterator = iterator.getNext();
        }
        Node<T> newNode = new Node<>(data);
        iterator.setNext(newNode);
    }

    /**
     * gets the size of the linked list.
     * @return the count of the list
     */
    public int size() {
        int counter = 0;
        Node<T> iterator = head;
        while (iterator.getNext() != null) {
            iterator = iterator.getNext();
            counter++;
        }
        return counter;
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
        Node<T> currentNode = head;
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
    public void add(T data, int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > size() + 1) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> currentNode = head;
        Node<T> previousNode = head;
        for (int currentIndex = 0; currentIndex <= index; currentIndex++) {
            if (currentIndex == index) {
                Node<T> newNode = new Node<>(data);
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
     * @return the data of the deleted node
     * @throws IndexOutOfBoundsException if the index is too small or too large
     */
    public Object remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> currentNode = head;
        Node<T> previousNode = head;
        for (int currentIndex = 0; currentIndex <= index; currentIndex++) {
            if (currentIndex == index && index == 0) {
                Object returnNodeData = head.getData();
                head = head.getNext();
                return returnNodeData;
            } else if (currentIndex == index) {
                previousNode.setNext(currentNode.getNext());
                currentNode.setNext(null);
                return currentNode.getData();
            }
            previousNode = currentNode;
            currentNode = currentNode.getNext();
        }
        return null;
    }







    /**
     * The node class.
     *
     * @param <T> the type of the node.
     * @author keegan
     * @version 2020
     */
    public static class Node<T> {
        private T data;
        private Node<T> next;

        /**
         * creates a node object.
         * @param data the object to store in the node
         */
        public Node(final T data) {
            this.data = data;
            next = null;
        }

        /**
         * gets the data of the node.
         * @return the data object of the node
         */
        public T getData() {
            return data;
        }

        /**
         * gets the next nodes address.
         * @return the next nodes address
         */
        public Node<T> getNext() {
            return next;
        }

        /**
         * sets the data of the current node.
         * @param data the data to store in the
         */
        public void setData(T data) {
            this.data = data;
        }

        /**
         * sets the next node.
         * @param next the next node to set
         */
        public void setNext(Node<T> next) {
            this.next = next;
        }

        /**
         * creates a string stating the current node.
         * @return a formatted string
         */
        @Override
        public String toString() {
            return "Node{"
                    + "data=" + data
                    + ", next=" + next
                    + '}';
        }

        /**
         * compares two objects.
         * @param o the object to compare
         * @return whether they are the same or not
         */
        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Node)) {
                return false;
            }
            Node<?> node = (Node<?>) o;
            return Objects.equals(getData(), node.getData())
                    && Objects.equals(getNext(), node.getNext());
        }

        /**
         * generates hashcode for the node object.
         * @return the hashcode
         */
        @Override
        public int hashCode() {
            return Objects.hash(getData(), getNext());
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
        LinkedList<?> that = (LinkedList<?>) o;
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
