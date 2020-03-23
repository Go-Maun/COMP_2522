package ca.bcit.comp2522.labs.lab06;

import java.util.Objects;

/**
 * The node class.
 *
 * @author keegan
 * @version 2020
 */
public class Node {
    private Object data;
    private Node next;

    /**
     * creates a node object.
     * @param data the object to store in the node
     */
    public Node(final Object data) {
        this.data = data;
        next = null;
    }

    /**
     * gets the data of the node.
     * @return the data object of the node
     */
    public Object getData() {
        return data;
    }

    /**
     * gets the next nodes address.
     * @return the next nodes address
     */
    public Node getNext() {
        return next;
    }

    /**
     * sets the data of the current node.
     * @param data the data to store in the
     */
    public void setData(Object data) {
        this.data = data;
    }

    /**
     * sets the next node.
     * @param next the next node to set
     */
    public void setNext(Node next) {
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
        Node node = (Node) o;
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
