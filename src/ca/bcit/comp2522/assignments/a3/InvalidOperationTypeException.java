package ca.bcit.comp2522.assignments.a3;

/**
 * the InvalidOperationTypeException class.
 *
 * @author keegan
 * @version 2020
 */
public class InvalidOperationTypeException extends Exception {

    /**
     * throws an InvalidOperationTypeException exception with no parameters.
     */
    public InvalidOperationTypeException() {
        super();
    }

    /**
     * throws an InvalidOperationTypeException exception with one parameter.
     * @param string the string to print to the user
     */
    public InvalidOperationTypeException(String string) {
        System.out.println(string);
    }
}
