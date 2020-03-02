package ca.bcit.comp2522.assignments.a3;

/**
 * the SubtractionOperation class.
 *
 * @author keegan
 * @version 2020
 */
public class SubtractionOperation extends AbstractOperation {
    /**
     * the constant char for subtraction.
     */
    public static char SUBTRACTION_CODE = '-';

    /**
     * creates a SubtractionOperation object.
     */
    public SubtractionOperation() {
        super(SUBTRACTION_CODE);
    }

    /**
     * calculates the subtraction of 2 values.
     * @param operandA the first int operand
     * @param operandB the secong int operand
     * @return the 2 values subtracted
     */
    @Override
    public int perform(int operandA, int operandB) {
        return operandA - operandB;
    }
}
