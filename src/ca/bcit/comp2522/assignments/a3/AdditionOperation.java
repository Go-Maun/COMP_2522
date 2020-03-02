package ca.bcit.comp2522.assignments.a3;

/**
 * the AdditionOperation class.
 *
 * @author keegan
 * @version 2020
 */
public class AdditionOperation extends AbstractOperation {
    /**
     * the static constant for addition.
     */
    public static char ADDITION_CODE = '+';

    /**
     * creates an addition object.
     */
    public AdditionOperation() {
        super(ADDITION_CODE);
    }

    /**
     * adds two numbers together.
     * @param operandA the first int operand
     * @param operandB the second int operand
     * @return the two operands added together
     */
    @Override
    public int perform(int operandA, int operandB) {
        return operandA + operandB;
    }
}
