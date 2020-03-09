package ca.bcit.comp2522.assignments.a3;

/**
 * the ModulusOperation class.
 *
 * @author keegan
 * @version 2020
 */
public class ModulusOperation extends AbstractOperation {
    /**
     * the static constant for modulus.
     */
    public static char MODULUS_CODE = '%';

    /**
     * creates an addition object.
     */
    public ModulusOperation() {
        super(MODULUS_CODE);
    }

    /**
     * modulus' two numbers together.
     *
     * @param operandA the first int operand
     * @param operandB the second int operand
     * @return the two operands added together
     */
    @Override
    public int perform(int operandA, int operandB) {
        return operandB % operandA;
    }
}
