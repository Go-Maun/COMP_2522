package ca.bcit.comp2522.labs.lab04;

public class Circle extends Shape2D {
    private double radius;

    public Circle(double radius) {
        super();
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("drawing a circle");
    }

    @Override
    public double getArea() {
        return PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * PI * radius;
    }
}
