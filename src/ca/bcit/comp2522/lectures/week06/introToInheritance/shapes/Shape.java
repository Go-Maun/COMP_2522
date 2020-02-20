package ca.bcit.comp2522.lectures.week06.introToInheritance.shapes;

/**
 * Shape.
 *
 * @author BCIT
 * @version 2020
 */
public abstract class Shape {

    private String shapeName;

    /**
     * Returns the surface area of this Shape.
     *
     * @return surfaceArea as a double
     */
    public abstract double surfaceArea();

    /**
     * Returns a String representation of this Shape.
     *
     * @return description as a String
     */
    public String toString() {
        return "Shape";
    }

}
