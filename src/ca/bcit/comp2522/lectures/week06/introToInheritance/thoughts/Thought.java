package ca.bcit.comp2522.lectures.week06.introToInheritance.thoughts;

/**
 * Represents a stray thought. Used as the parent of a derived class to
 * demonstrate the use of an overridden method.
 *
 * @author Lewis & Loftus 9e
 * @author BCIT
 * @version 2020
 */
public class Thought {

    /**
     * Prints a message.
     */
    public void message() {
        System.out.println("I feel like I'm diagonally parked in a "
                + "parallel universe.");

        System.out.println();
    }
}

