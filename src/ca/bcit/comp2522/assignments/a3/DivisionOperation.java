package ca.bcit.comp2522.assignments.a3;

public class DivisionOperation extends AbstractOperation {
    public static char DIVISION_CODE = '/';

    public DivisionOperation() {
        super(DIVISION_CODE);
    }

    @Override
    public int perform(int operandA, int operandB) {
        return operandA / operandB;
    }
}
