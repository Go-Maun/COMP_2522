package ca.bcit.comp2522.labs.lab03;

/**
 * the tree class.
 *
 * @author keegan
 * @version 2020
 */
public class Tree {
    /**
     * the different species of trees.
     */
    public enum Species { MAPLE, ARBUTUS, BLUE_SPRUCE }
    private Species type;
    private int ageInYears;
    private double circumferenceInCentimeters;

    public Tree(Species type, int ageInYears, double circumferenceInCentimeters) {
        if (ageInYears < 0 || circumferenceInCentimeters < 0) {
            throw new IllegalArgumentException();
        }
        this.type = type;
        this.ageInYears = ageInYears;
        this.circumferenceInCentimeters = circumferenceInCentimeters;
    }

    public Tree(int ageInYears, double circumferenceInCentimeters) {
        this(Species.MAPLE, ageInYears, circumferenceInCentimeters);
    }

    public void setAgeInYears() {
        ageInYears++;
    }

    public void setCircumferenceInCentimeters(double circumferenceInCentimeters) {
        if (this.circumferenceInCentimeters < circumferenceInCentimeters) {
            this.circumferenceInCentimeters = circumferenceInCentimeters;
        }
    }

    public double getCircumferenceInCentimeters() {
        return circumferenceInCentimeters;
    }

    public int getAgeInYears() {
        return ageInYears;
    }

    public Species getType() {
        return type;
    }
}
