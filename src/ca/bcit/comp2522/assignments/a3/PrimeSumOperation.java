package ca.bcit.comp2522.assignments.a3;

/**
 * the PrimeSumOperator class.
 *
 * @author Keegan
 * @version 2020
 */
public class PrimeSumOperation extends AbstractOperation {

    /**
     * the static constant for prime sum.
     */
    public static char PRIME_SUM_CODE = '@';

    /**
     * creates an AbstractOperation object.
     */
    public PrimeSumOperation() {
        super(PRIME_SUM_CODE);
    }

    /**
     * calculates the sum of all numbers between and including the 2 operands.
     * @param operandA the first operand
     * @param operandB the second operand
     * @return the total of all sums
     */
    @Override
    public int perform(int operandA, int operandB) {
        final int isPrime = 1;
        int total = 0;
        if (operandB > operandA) {
            int temp = operandB;
            operandB = operandA;
            operandA = temp;
        }
        for (int currentNum = operandB; currentNum <= operandA; currentNum++) {
            int totalDivisions = 0;
            if (currentNum > 1) {
                for (int currentCompare = operandB; currentCompare <= operandA; currentCompare++) {
                    if (currentCompare > 1 && currentNum % currentCompare == 0) {
                        totalDivisions++;
                    }
                }
            }
            if (totalDivisions == isPrime) {
                total += currentNum;
            }
        }
        return total;
    }
}
