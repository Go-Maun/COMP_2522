package ca.bcit.comp2522.labs.lab05;

public class Driver {

    public static void printList(LinkedList list) {
        Node iterator = list.getHead();
        while (iterator.getNext() != null) {
            System.out.println(iterator.getData());
            iterator = iterator.getNext();
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Double pi = 3.14;
        Integer thirty = 30;
        String name = "keegan";
        list.add(pi);
        list.add(thirty);
        printList(list);
        list.add(name);
        System.out.println("new print");
        printList(list);
    }
}
