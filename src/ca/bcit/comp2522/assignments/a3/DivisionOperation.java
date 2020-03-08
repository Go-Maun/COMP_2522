package ca.bcit.comp2522.assignments.a3;

/**
 * the divisionOperation class.
 *
 * @author keegan
 * @version 2020
 */
public class DivisionOperation extends AbstractOperation {
    /**
     * the constant character for division.
     */
    public static char DIVISION_CODE = '/';

    /**
     * creates a DivisionOperation object.
     */
    public DivisionOperation() {
        super(DIVISION_CODE);
    }

    /**
     * calculates division between 2 operands.
     * @param operandA the first operand
     * @param operandB the second operand
     * @return the 2 operands divided
     */
    @Override
    public int perform(int operandA, int operandB) {
        return operandB / operandA;
    }
}
