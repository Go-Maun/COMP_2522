package ca.bcit.comp2522.labs.lab04;

public class RegularPolygon extends Polygon{
    private double length;
    private double apothem;

    public RegularPolygon(int sides, double length, double apothem) {
        super(sides);
        this.apothem = apothem;
        this.length = length;
    }

    @Override
    public void draw() {
        System.out.println("drawing a polygon");
    }

    @Override
    public double getArea() {
        final double pointFive = 0.5;
        return getPerimeter() * pointFive * apothem;
    }

    @Override
    public double getPerimeter() {
        return length * numberOfSides;
    }
}
