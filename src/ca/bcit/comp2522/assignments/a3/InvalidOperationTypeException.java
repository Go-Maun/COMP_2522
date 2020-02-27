package ca.bcit.comp2522.assignments.a3;

public class InvalidOperationTypeException extends Exception {

    public InvalidOperationTypeException() {
        super();
    }

    public InvalidOperationTypeException(String string) {
        System.out.println(string);
    }
}
