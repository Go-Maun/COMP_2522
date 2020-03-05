package ca.bcit.comp2522.quizzes.quiz04;

import java.util.Objects;

public class Node {
    private Object data;
    private Node next;

    public Node(final Object data) {
        this.data = data;
        next = null;
    }

    public Object getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node node = (Node) o;
        return Objects.equals(getData(), node.getData()) &&
                Objects.equals(getNext(), node.getNext());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getData(), getNext());
    }
}
