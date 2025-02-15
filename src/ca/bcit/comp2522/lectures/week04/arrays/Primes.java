package ca.bcit.comp2522.lectures.week04.arrays;

/**
 * Demonstrates the use of an initializer list for an array.
 *
 * @author Lewis & Loftus 9e
 * @author BCIT
 * @version 2020
 */
public class Primes {

    private static final int[] PRIMES =
            {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31};

    /**
     * Stores some prime numbers in an array and prints them.
     *
     * @param args command line arguments (unused)
     */
    public static void main(String[] args) {

        System.out.println("Array length: " + PRIMES.length);

        System.out.println("The first few prime numbers are:");

        for (int prime : PRIMES) {
            System.out.print(prime + "  ");
        }
    }
}

