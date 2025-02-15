package ca.bcit.comp2522.lectures.week03.scanner;

import java.util.Scanner;

/**
 * Demonstrates the use of the nextLine method of the Scanner class to read a
 * string from the user.
 *
 * @author Lewis & Loftus 9e
 * @author BCIT
 * @version 2020
 */
public class Echo {

    /**
     * Reads a character string from the user and prints it.
     *
     * @param args command line arguments (unused)
     */
    public static void main(String[] args) {

        System.out.println("Enter a line of text:");
        final Scanner scan = new Scanner(System.in);
        final String message = scan.nextLine();
        System.out.println("You entered: \"" + message + "\"");
        scan.close();
    }
}

