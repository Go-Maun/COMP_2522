package ca.bcit.comp2522.lectures.week08.orderOfInitialization;

class Art {
    public Art() {
        System.out.println("Art constructor");
    }
}

class Drawing extends Art {
    public Drawing() {
        System.out.println("Drawing constructor");
    }
}

/**
 * Pay attention to the order of execution.  This is quite
 * linear, but it demonstrates the fundamental principle
 * that the calls to super go all the way up the hierarchy.
 *
 * @author BCIT
 * @version 2020
 */
public class Cartoon extends Drawing {
    public Cartoon() {
        System.out.println("Cartoon constructor");
    }

    /**
     * Drives the program.
     * @param args
     */
    public static void main(String[] args) {

        Cartoon x = new Cartoon();
    }
}