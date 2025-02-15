package ca.bcit.comp2522.lectures.week02.controlStatements;

/**
 * Demonstrates the use of nested for loops.
 *
 * @author Lewis & Loftus 9e
 * @author BCIT
 * @version 2020
 */
public class Stars {

    /**
     * Prints a triangle shape using asterisk (star) characters.
     *
     * @param args command line arguments (unused)
     */
    public static void main(String[] args) {
        final int maxRows = 10;

        for (int row = 1; row <= maxRows; row++) {
            for (int star = 1; star <= row; star++) {
                System.out.print("*");
            } // Pay attention to the closing braces!
            System.out.println();
        }
    }
}

