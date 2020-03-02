package ca.bcit.comp2522.assignments.a3;

/**
 * the StackOverflowException exception class.
 *
 * @author keegan
 * @version 2020
 */
public class StackOverflowException extends Exception {

    /**
     * 0 parameter exception for StackOverflowException.
     */
    public StackOverflowException() {
        super();
    }

    /**
     * 1 parameter exception for StackOverflowException.
     * @param string the string to print to the user
     */
    public StackOverflowException(String string) {
        System.out.println(string);
    }
}
