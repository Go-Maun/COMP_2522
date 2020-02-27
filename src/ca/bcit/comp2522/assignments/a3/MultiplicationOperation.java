package ca.bcit.comp2522.assignments.a3;

public class MultiplicationOperation extends AbstractOperation {
    public static char MULTIPLICATION_CODE = '*';

    public MultiplicationOperation() {
        super(MULTIPLICATION_CODE);
    }

    @Override
    public int perform(int operandA, int operandB) {
        return operandA * operandB;
    }
}
