package ca.bcit.comp2522.labs.lab05;

import java.util.Iterator;

public class LinkedList {
    private Node head;

    public LinkedList() {
        head = null;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public void add(Object data) {
        if (head == null) {
            head = new Node(data);
        } else {
            Node iterator = head;
            while (iterator.getNext() != null) {
                iterator = iterator.getNext();
            }
            Node newNode = new Node(data);
            iterator.setNext(newNode);
        }
    }
}
