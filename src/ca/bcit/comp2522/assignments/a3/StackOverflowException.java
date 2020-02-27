package ca.bcit.comp2522.assignments.a3;

public class StackOverflowException extends Exception {

    public StackOverflowException() {
        super();
    }

    public StackOverflowException(String string) {
        System.out.println(string);
    }
}
