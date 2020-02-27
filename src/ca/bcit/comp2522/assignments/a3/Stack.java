package ca.bcit.comp2522.assignments.a3;

public class Stack {
    private int[] stackValues;
    private int count;

    public Stack(int arraySize) throws IllegalArgumentException {
        if (arraySize < 1) {
            throw new IllegalArgumentException();
        }
        stackValues = new int[arraySize];
        count = 0;
    }

    public int capacity() {
        return stackValues.length;
    }

    public int size() {
        return count;
    }

    public int unused() {
        return capacity() - size();
    }

    public void push(int value) throws StackOverflowException {
        if (size() == capacity()) {
            throw new StackOverflowException("This stack is full!");
        } else {
            stackValues[size()] = value;
        }
        count++;
    }

    public int pop() throws StackUnderflowException {
        /*might be a problem with if statement, well see*/
        if (size() == 0) {
            throw new StackUnderflowException("Cannot call Stack.pop() on an empty stack!");
        } else {
            int temp = stackValues[size() - 1];
            /*this might also not be 100% right*/
            stackValues[size() - 1] = 0;
            count--;
            return temp;
        }
    }

    public int peek() throws StackUnderflowException {
        if (size() == 0) {
            throw new StackUnderflowException("Cannot call Stack.peek() on an empty stack!");
        } else {
            return stackValues[size() - 1];
        }
    }



}
