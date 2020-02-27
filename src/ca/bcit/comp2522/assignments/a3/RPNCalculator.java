package ca.bcit.comp2522.assignments.a3;

import java.util.Scanner;

public class RPNCalculator {
    private static int MIN_STACK_SIZE = 2;

    private Stack stack;

    public RPNCalculator(int stackSize) throws IllegalArgumentException {
        if (stackSize < MIN_STACK_SIZE) {
            throw new IllegalArgumentException();
        } else {
            stack = new Stack(stackSize);
        }
    }

    public int processFormula(final String formula) throws IllegalArgumentException,
            StackOverflowException, InvalidOperationTypeException, StackUnderflowException {

        Operation operation;

        if (formula == null || formula.equals("")) {
            throw new IllegalArgumentException();
        }
        Scanner scanner = new Scanner(formula);
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                push(scanner.nextInt());
            } else {
                operation = getOperation(scanner.next().charAt(0));
                perform(operation);
            }
        }

        return getResult();
    }

    public void push(final int operand) throws StackOverflowException {
        if (stack.unused() == 0) {
            throw new StackOverflowException("The stack is full!");
        }
        stack.push(operand);
    }

    public Operation getOperation(final char symbol) throws InvalidOperationTypeException {
        Operation operation;
        switch (symbol) {
            case '+':
                operation = new AdditionOperation();
                break;
            case '-':
                operation = new SubtractionOperation();
                break;
            case '*':
                operation = new MultiplicationOperation();
                break;
            case '/':
                operation = new DivisionOperation();
                break;
            default:
                throw new InvalidOperationTypeException("Invalid Operation Type");
        }
        return operation;
    }

    public int getResult() throws StackUnderflowException {
        if (stack.size() == 0) {
            throw new StackUnderflowException("There are no operands!");
        }
        return stack.peek();
    }

    private void perform(final Operation operation) throws IllegalArgumentException,
            StackUnderflowException, StackOverflowException {

        if (operation == null) {
            throw new IllegalArgumentException("Operation cannot be null!");
        }
        push(operation.perform(stack.pop(), stack.pop()));
    }

}
