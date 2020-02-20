package ca.bcit.comp2522.lectures.week05.exceptions;

/**
 * This is NOT how we want to deal with Exceptions. This approach
 * is not Java style.  This is possibly more Pythonic.
 *
 * @author BCIT
 * @version 2020
 */
public class DontDoThis {

    /**
     * Drives the program.
     * @param args unused
     */
    public static void main(String[] args) {
        String hello = "Blue";

        // This makes Java developers' eyes bleed
        try {
            int index = 0;
            while (true) {
                System.out.println(hello.charAt(index));
                index++;
            }
        } catch(Exception e) { }
    }
}
