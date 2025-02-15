package ca.bcit.comp2522.assignments.a3;

import java.util.Scanner;

/**
 * the RPNCalculator class.
 *
 * @author keegan
 * @version 2020
 */
public class RPNCalculator {
    /**
     * the minimum stack size.
     */
    public static int MIN_STACK_SIZE = 2;

    private Stack stack;

    /**
     * creates an RPNCalculator object.
     * @param stackSize the size of the stack
     * @throws IllegalArgumentException if the stackSize is too small
     */
    public RPNCalculator(int stackSize) throws IllegalArgumentException {
        if (stackSize < MIN_STACK_SIZE) {
            throw new IllegalArgumentException();
        } else {
            stack = new Stack(stackSize);
        }
    }

    /**
     * processes the given string formula.
     * @param formula a string with all numbers and operations
     * @return the final calculation
     * @throws IllegalArgumentException thrown when perform does not have an operation object
     * @throws StackOverflowException thrown when the stack is full
     * @throws InvalidOperationTypeException thrown when an invalid operation is in getOperation
     * @throws StackUnderflowException thrown when the stack is empty
     */
    public int processFormula(final String formula) throws IllegalArgumentException,
            StackOverflowException, InvalidOperationTypeException, StackUnderflowException {

        Operation operation;

        if (formula == null) {
            throw new IllegalArgumentException();
        } else if (formula.equals("")) {
            throw new StackUnderflowException();
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
        scanner.close();
        return getResult();
    }

    /**
     * pushes a value onto the stack.
     * @param operand the int operand to put onto the stack
     * @throws StackOverflowException thrown if the stack is full
     */
    public void push(final int operand) throws StackOverflowException {
        if (stack.unused() == 0) {
            throw new StackOverflowException("The stack is full!");
        }
        stack.push(operand);
    }

    /**
     * creates an operation object depending on symbol.
     * @param symbol determines the operation to create
     * @return an operation object
     * @throws InvalidOperationTypeException thrown when an invalid operation is handed
     */
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
            case '%':
                operation = new ModulusOperation();
                break;
            case '@':
                operation = new PrimeSumOperation();
                break;
            default:
                throw new InvalidOperationTypeException("Invalid Operation Type");
        }
        return operation;
    }

    /**
     * gets the result on the stack, stored in the first position.
     * @return returns the int value
     * @throws StackUnderflowException thrown of the stack is too small
     */
    public int getResult() throws StackUnderflowException {
        if (stack.size() == 0) {
            throw new StackUnderflowException("There are no operands!");
        }
        return stack.peek();
    }

    /**
     * performs math based on the operation given.
     * @param operation the operation in which to perform the math with
     * @throws IllegalArgumentException thrown when perform does not have an operation object
     * @throws StackUnderflowException thrown if the stack is too small
     * @throws StackOverflowException thrown is the stack is too full
     */
    public void perform(final Operation operation) throws IllegalArgumentException,
            StackUnderflowException, StackOverflowException {

        if (operation == null) {
            throw new IllegalArgumentException("Operation cannot be null!");
        }
        push(operation.perform(stack.pop(), stack.pop()));
    }

    /**
     * Drives the program by evaluating the RPN calculation provided as
     * a command line argument.
     *
     * Example usage: RPNCalculator 10 "1 2 +"
     *
     * Note that the formula MUST be placed inside of double quotes.
     *
     * @param argv - the command line arguments are the size of the Stack
     * to be created followed by the expression to evaluate.
     */
    public static void main(final String[] argv) {
// Checks for correct number of command line arguments.
        if (argv.length != 2) {
            System.err.println("Usage: Main <stack size> <formula>");
            System.exit(1);
        }
// Initializes stack and RPNCalculator.
        final int stackSize = Integer.parseInt(argv[0]);
        final RPNCalculator calculator = new RPNCalculator(stackSize);
        try {
            System.out.println("[" + argv[1] + "] = "
                    + calculator.processFormula(argv[1]));
        } catch (final InvalidOperationTypeException ex) {
            System.err.println("formula can only contain integers, +, -, *, and /");
        } catch (final StackOverflowException ex) {
            System.err.println("too many operands in the formula, increase the stack size");
        } catch (final StackUnderflowException ex) {
            System.err.println("too few operands in the formula");
        }
    }

}
