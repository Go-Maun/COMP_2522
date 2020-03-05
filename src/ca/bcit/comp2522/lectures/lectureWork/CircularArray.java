package ca.bcit.comp2522.lectures.lectureWork;

import java.util.Scanner;

public class CircularArray {
    private int size;
    private int frontPointer;
    private int endPointer;
    private int length;
    private int[] circleArray;

    public CircularArray(int arrayLength) {
        size = arrayLength;
        frontPointer = endPointer = 0;
        endPointer = 0;
        length = 0;
        circleArray = new int[arrayLength];
    }

    private void printArray() {
        for (int value : circleArray) {
            System.out.print(value);
            System.out.print(" ");
        }
        System.out.println();
    }

    private void removeElement() {
        if (!(size == 0)) {
            length--;
            frontPointer = (frontPointer + 1) % size;
            circleArray[frontPointer] = 0;
        } else {
            System.out.println("underflow exception");
        }
    }

    private void addElement(Scanner scanner) {
        if (!(size == length)) {
            length++;
            endPointer = (endPointer + 1) % size;
            System.out.println("an int?");
            try {
                circleArray[endPointer] = scanner.nextInt();
                scanner.nextLine();
            } catch (java.util.InputMismatchException e){
                System.out.println("youre a fuckin dumbass, like holy shit, who in their " +
                        "right mind would even THINK to put something that isnt an integer here " +
                        "like HOLy SHIT I HATE YOU");
                System.exit(1);
            }
        } else {
            System.out.println("underflow exception");
        }
    }

    private void choose(Scanner scanner) {
        System.out.println("what is the choice? 1 for add 2 for remove end element");
        int choice = 0;
        try {
            choice = scanner.nextInt();
            scanner.nextLine();
        } catch (java.util.InputMismatchException e){
            System.out.println("youre a fuckin dumbass, like holy shit, who in their " +
                    "right mind would even THINK to put something that isnt an integer here " +
                    "like HOLy SHIT I HATE YOU");
            System.exit(1);
        }
        switch (choice) {
            case 1:
                addElement(scanner);
                break;
            case 2:
                removeElement();
                break;
            default:
                throw new IllegalArgumentException();
        }
    }

    private void getInt(Scanner scanner) {
        char answer = 'y';
        while (answer == 'y' || answer == 'Y') {
            try {
                choose(scanner);
            } catch (IllegalArgumentException e){
                System.out.println("bruh, it says 1 or 2, are you dumb?");
                System.exit(1);
            }
            printArray();
            System.out.println("continue? (yes (y) or no (n))");
            answer = scanner.nextLine().charAt(0);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int length = 0;
        System.out.println("how many array slots? (int)");
        while (length < 2) {
            try {
                length = scan.nextInt();
                scan.nextLine();
            } catch (java.util.InputMismatchException e){
                System.out.println("youre a fuckin dumbass, like holy shit, who in their " +
                        "right mind would even THINK to put something that isnt an integer here " +
                        "like HOLy SHIT I HATE YOU");
                System.exit(1);
            }
            if (length < 2) {
                System.out.println("not gonna work try again asshole");
            }
        }
        CircularArray object = new CircularArray(length);
        object.getInt(scan);
    }
}
