package ca.bcit.comp2522.assignments.a3;

/**
 * the Stack class.
 *
 * @author keegan
 * @version 2020
 */
public class Stack {
    private int[] stackValues;
    private int count;

    /**
     * creates a Stack object.
     * @param arraySize the size of the stack
     * @throws IllegalArgumentException if the stack size given is 0 or below
     */
    public Stack(int arraySize) throws IllegalArgumentException {
        if (arraySize < 1) {
            throw new IllegalArgumentException();
        }
        stackValues = new int[arraySize];
        count = 0;
    }

    /**
     * gets the total capacity for the stack.
     * @return the capacity
     */
    public int capacity() {
        return stackValues.length;
    }

    /**
     * gets the number of items on the stack.
     * @return the number of items
     */
    public int size() {
        return count;
    }

    /**
     * gets the number of unused spaces on the stack.
     * @return the empty spaces on the stack
     */
    public int unused() {
        return capacity() - size();
    }

    /**
     * pushes an item onto the stack.
     * @param value the int to put onto the stack
     * @throws StackOverflowException thrown if the stack is full
     */
    public void push(int value) throws StackOverflowException {
        if (size() == capacity()) {
            throw new StackOverflowException("This stack is full!");
        } else {
            stackValues[size()] = value;
        }
        count++;
    }

    /**
     * removes the first item from the stack and returns it.
     * @return the removed item
     * @throws StackUnderflowException thrown if the stack is empty
     */
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

    /**
     * returns the first item on the stack without removing it.
     * @return the first item on the stack
     * @throws StackUnderflowException thrown if the stack is empty
     */
    public int peek() throws StackUnderflowException {
        if (size() == 0) {
            throw new StackUnderflowException("Cannot call Stack.peek() on an empty stack!");
        } else {
            return stackValues[size() - 1];
        }
    }
}
