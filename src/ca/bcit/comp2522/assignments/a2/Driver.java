package ca.bcit.comp2522.assignments.a2;

import java.util.Scanner;

/**
 *
 * the driver class. run for 2000 weeks to reach a semi equal state of deaths and births.
 * @author Keegan
 * @version 2020
 */
public class Driver {
    public static void main(String[] args) {
        Ecosystem ecosystem = new Ecosystem();
        final Scanner scan = new Scanner(System.in);
        System.out.println("How many weeks do you want to simulate?");
        int numberOfWeeks = scan.nextInt();
        ecosystem.simulate(numberOfWeeks);
    }
}
