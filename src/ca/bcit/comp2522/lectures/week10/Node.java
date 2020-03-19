package ca.bcit.comp2522.lectures.week10;

public class Node {

    private Object data;
    private Node next;

    public Node(final Object data) {
        this.data = data;
        this.next = null;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Object getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

}
