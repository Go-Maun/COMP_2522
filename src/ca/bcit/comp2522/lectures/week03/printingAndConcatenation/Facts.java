package ca.bcit.comp2522.lectures.week03.printingAndConcatenation;

/**
 * Demonstrates the use of the string concatenation operator and the automatic
 * conversion of an integer to a string.
 *
 * @author Lewis & Loftus 9e
 * @author BCIT
 * @version 2020
 */
public class Facts {

    /**
     * Prints various facts.
     *
     * @param args command line arguments (unused)
     */
    public static void main(String[] args) {

        // Strings can be concatenated into one long String
        System.out.println("We present the following facts for your "
                + "extracurricular edification:");

        System.out.println();

        // A String can contain numeric digits
        System.out.println("Letters in the Hawaiian alphabet: 12");

        // A numeric value can be concatenated to a String
        System.out.println("Dialing code for Antarctica: " + 672);

        System.out.println("Year in which Leonardo da Vinci invented "
                + "the parachute: " + 1515);

        System.out.println("Speed of ketchup: " + 40 + " km per year");
    }
}

