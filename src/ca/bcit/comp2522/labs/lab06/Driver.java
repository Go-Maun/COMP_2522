package ca.bcit.comp2522.labs.lab06;

public class Driver {

    public static void printList(LinkedList list) {
        Node iterator = list.getHead();
        boolean end = false;
        while (!end) {
            System.out.print(iterator.getData());
            System.out.println(" ");
            iterator = iterator.getNext();
            if (iterator == null) {
                end = true;
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Node newHead = new Node(0);
        list.setHead(newHead);
        printList(list);
        list.append(1);
        printList(list);
        list.prepend(2);
        printList(list);
        list.add(3, 1);
        printList(list);
        list.remove(2);
        printList(list);
        list.add(4, 3);
        printList(list);
        list.add(5,  0);
        System.out.println(list.size());
        System.out.println();
        printList(list);
        list.remove(0);
        printList(list);
        list.remove(3);
        printList(list);
        list.clear();
        Node head = new Node(4);
        list.setHead(head);
        printList(list);
    }
}
