package ca.bcit.comp2522.lectures.generics;

public class EmptyStackException extends RuntimeException {

    public EmptyStackException() {
        this("Stack is empty");
    }

    public EmptyStackException(String exception) {
        super(exception);
    }
}