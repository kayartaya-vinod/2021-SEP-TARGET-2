package co.vinod.training.programs;

import co.vinod.training.entity.Circle;
import co.vinod.training.entity.Shape;
import co.vinod.training.entity.Triangle;

public class PolymorphismDemo {

    static void printShapeDetails(Shape shape){
        System.out.println("Printing the details of a " + shape.getShapeName());

        if(shape instanceof  Circle){
            Circle c = (Circle) shape;
            System.out.printf("Area of Circle with radius %.2f is %.2f sq.units.\n",
                    c.getRadius(), shape.getArea());
        }
        else if (shape instanceof Triangle){
            Triangle t = (Triangle) shape;
            System.out.printf("Area of Triangle with base of %.2f and height of %.2f is %.2f sq.units\n",
                    t.getBase(), t.getHeight(), t.getArea());
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Circle c1 = new Circle(12.34);
        Triangle t1 = new Triangle(12.34, 56.78);

        printShapeDetails(c1); // this works because, Circle is a Shape
        printShapeDetails(t1); // this works because, Triangle is a Shape
    }
}
