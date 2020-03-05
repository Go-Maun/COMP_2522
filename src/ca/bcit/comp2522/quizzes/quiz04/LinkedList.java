package ca.bcit.comp2522.quizzes.quiz04;


/**
 *
 * @author Keegan Maundrell A01172483
 * @author Lawrance On A01165970
 *
 * @version 2020
 */
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

    public void prepend(Object data) {
        Node newHead = new Node(data);
        newHead.setNext(head);
        head = newHead;
    }

    public void append(Object data) {
        Node iterator = head;
        while (iterator.getNext() != null) {
            iterator = iterator.getNext();
        }
        Node newNode = new Node(data);
        iterator.setNext(newNode);
    }

    public int size() {
        int counter = 0;
        Node iterator = head;
        while (iterator.getNext() != null) {
            iterator = iterator.getNext();
            counter++;
        }
        return counter;
    }

    public void clear() {
        head = null;
    }

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

    public void add(Object data, int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        Node currentNode = head;
        Node previousNode = head;
        for (int currentIndex = 0; currentIndex <= index; currentIndex++) {
            if (currentIndex + 1 == index) {
                previousNode = currentNode;
            } else if (currentIndex == index) {
                Node newNode = new Node(data);
                previousNode.setNext(newNode);
                newNode.setNext(currentNode);
            }
            currentNode = currentNode.getNext();
        }
    }

    /**
     * counts until it reaches a given object
     *
     * @param o object given
     * @return the count to reach the object
     * @throws IllegalArgumentException object handed is null
     * @throws EmptyListException       the list is empty
     */
    public int count(Object o) throws IllegalArgumentException, EmptyListException {
        boolean end = false;
        if (o == null) {
            throw new IllegalArgumentException();
        }
        if (head == null) {
            throw new EmptyListException("list is empty");
        }
        int count = 0;
        Node it = head;
        while (!end) {
            count++;
            if (it.getData().equals(o)) {
                return count;
            }
            it = it.getNext();
            if (it == null) {
                end = true;
            }
        }
        return 0;
    }

    public static void main(String[] args) throws EmptyListException {
        Node headNode = new Node(3);
        LinkedList list = new LinkedList();
        list.setHead(headNode);
        list.append(3);
        list.append(3);
        list.append(2);
        int count = list.count(2);
        System.out.println(count);
    }
}
