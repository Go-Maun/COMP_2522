package ca.bcit.comp2522.assignments.a3;

/**
 * the abstract AbstractOperation class.
 *
 * @author keegan
 * @version 2020
 */
public abstract class AbstractOperation implements Operation {

    /**
     * the character of the operation type.
     */
    protected char operationType;

    /**
     * creates an AbstractOperation object.
     * @param operand the supplied operand character
     */
    public AbstractOperation(char operand) {
        operationType = operand;
    }

    /**
     * gets the symbol.
     * @return the operation symbol
     */
    public final char getSymbol() {
        return operationType;
    }
}
