package ca.bcit.comp2522.lectures.week02.controlStatements;

import java.util.Scanner;

/**
 * Demonstrates the use of a for loop.
 *
 * @author Lewis & Loftus 9e
 * @author BCIT
 * @version 2019
 */
public class Multiples {

    /**
     * Prints multiples of a user-specified number up to a user-
     * specified limit.
     *
     * @param args command line arguments (unused)
     */
    public static void main(String[] args) {

        final Scanner scan = new Scanner(System.in);

        System.out.print("Enter a positive value: ");
        final int value = scan.nextInt();

        System.out.print("Enter an upper limit: ");
        final int limit = scan.nextInt();

        System.out.println();
        System.out.println("The multiples of " + value + " between "
                + value + " and " + limit + " (inclusive) are:");

        final int perLine = 5;
        int mult = 0;
        int count = 0;
        for (mult = value; mult <= limit; mult += value) {
            System.out.print(mult + "\t");

            // Prints a specific number of values per line of output
            count++;
            if (count % perLine == 0) {
                System.out.println();
            }
        }

        scan.close();
    }
}

