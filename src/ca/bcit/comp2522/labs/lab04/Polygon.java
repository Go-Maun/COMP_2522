package ca.bcit.comp2522.labs.lab04;

public abstract class Polygon extends Shape2D{
    protected int numberOfSides;
    protected Polygon(int numberOfSides) {
        this.numberOfSides = numberOfSides;
    }
}
