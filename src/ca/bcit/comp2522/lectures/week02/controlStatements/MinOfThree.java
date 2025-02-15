package ca.bcit.comp2522.lectures.week02.controlStatements;

import java.util.Scanner;

/**
 * Demonstrates the use of nested if statements.  We avoid these
 * if possible.  It can get confusing quickly.  Be judicious,
 * and comment your code when it gets complicated.
 *
 * @author Lewis & Loftus 9e
 * @author BCIT
 * @version 2020
 */
public class MinOfThree {

    /**
     * Reads three integers from the user and determines the smallest
     * value.
     *
     * @param args command line arguments (unused)
     */
    public static void main(String[] args) {

        System.out.println("Enter three integers: ");

        final Scanner scan = new Scanner(System.in);
        final int num1 = scan.nextInt();
        final int num2 = scan.nextInt();
        final int num3 = scan.nextInt();

        int min = 0;
        if (num1 < num2) {
            if (num1 < num3) {
                min = num1;
            } else {
                min = num3;
            }
        } else if (num2 < num3) {
            min = num2;
        } else {
            min = num3;
        }

        System.out.println("Minimum value: " + min);
        scan.close();
    }
}

