package ca.bcit.comp2522.lectures.week02.controlStatements;

/**
 * Demonstrates the use of nested for loops.
 *
 * @author Link
 * @author BCIT
 * @version 2020
 */
public class Wedge {

    /**
     * Prints a wedge shape using asterisk (star) characters.
     *
     * @param args command line arguments (unused)
     */
    public static void main(String[] args) {
        final int maxRows = 11;

        for (int row = 1; row <= maxRows; row++) {
            for (int blanks = 1; blanks <= maxRows - row; blanks++) {
                System.out.print(" ");
            }
            for (int star = 1; star <= 2 * row - 1; star++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

