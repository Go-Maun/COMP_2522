package ca.bcit.comp2522.assignments.a3;

/**
 * the Operation interface.
 *
 * @author keegan
 * @version 2020
 */
public interface Operation {
    char getSymbol();
    int perform(int operandA, int operandB);
}
