package ca.bcit.comp2522.assignments.a3;

public abstract class AbstractOperation implements Operation {
    protected char operationType;
    public AbstractOperation(char operand) {
        operationType = operand;
    }
    public final char getSymbol() {
        return operationType;
    }
}
