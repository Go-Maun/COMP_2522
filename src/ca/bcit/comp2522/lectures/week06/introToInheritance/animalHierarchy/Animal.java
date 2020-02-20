package ca.bcit.comp2522.lectures.week06.introToInheritance.animalHierarchy;

/**
 * Animal.
 *
 * @author BCIT
 * @version 2020
 */
public abstract class Animal {

    protected int age;

    /**
     * Constructs an object of type Animal.
     *
     * @param age a positive integer
     */
    public Animal(int age) {
        this.age = age;
    }

    /**
     * Eats.
     */
    abstract void eat();

    /**
     * Moves.
     */
    abstract void move();
}
