package ca.bcit.comp2522.assignments.a3;

/**
 * the multiplicationOperation class.
 *
 * @author keegan
 * @version 2020
 */
public class MultiplicationOperation extends AbstractOperation {

    /**
     * the constant character for multiplication.
     */
    public static char MULTIPLICATION_CODE = '*';

    /**
     * creates a MultiplicationOperation object.
     */
    public MultiplicationOperation() {
        super(MULTIPLICATION_CODE);
    }

    /**
     * calculates the multiplication value of 2 operands.
     * @param operandA the first int operand
     * @param operandB the second int operand
     * @return the value of the 2 operands multiplied
     */
    @Override
    public int perform(int operandA, int operandB) {
        return operandA * operandB;
    }
}
