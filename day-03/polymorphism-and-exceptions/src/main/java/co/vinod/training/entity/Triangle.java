package co.vinod.training.entity;

public class Triangle extends Shape {

    private double base;
    private double height;

    public Triangle() {
    }

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    // this function hides the visibility of super class getShapeName() method
    public String getShapeName() {
        return "Triangle";
    }

    @Override
    public double getArea() {
        return 0.5 * base * height;
    }
}
