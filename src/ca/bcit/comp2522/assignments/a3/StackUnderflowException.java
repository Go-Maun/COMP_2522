package ca.bcit.comp2522.assignments.a3;

/**
 * the StackUnderflowException exception class.
 *
 * @author keegan
 * @version 2020
 */
public class StackUnderflowException extends Exception {

    /**
     * 0 parameter exception for StackUnderflowException.
     */
    public StackUnderflowException() {
        super();
    }

    /**
     * 1 parameter exception for StackUnderflowException.
     * @param string the string to print to the user
     */
    public StackUnderflowException(String string) {
        System.out.println(string);
    }
}
