package ca.bcit.comp2522.labs.lab06;

public class Driver {

    public static void printList(LinkedList<?> list) {
        LinkedList.Node<?> iterator = list.getHead();
        boolean end = false;
        while (!end) {
            System.out.print(iterator.getData());
            System.out.print(", ");
            iterator = iterator.getNext();
            if (iterator == null) {
                end = true;
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        LinkedList.Node<Integer> newHead = new LinkedList.Node<>(0);
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
        System.out.printf("the size is %s\n", list.size());
        printList(list);
        list.remove(0);
        printList(list);
        list.remove(3);
        printList(list);
        list.clear();
        LinkedList.Node<Integer> head = new LinkedList.Node<>(4);
        list.setHead(head);
        printList(list);
    }
}
