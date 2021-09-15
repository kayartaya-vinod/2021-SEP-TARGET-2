package co.vinod.training.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// if you inherit from an abstract class with abstract functions, you must override all abstract
// methods in your class. or mark the class as abstract.
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rectangle extends Shape{

    private double width;
    private double breadth;

    @Override
    public String getShapeName() {
        return "Rectangle";
    }

    @Override
    public double getArea() {
        return 0;
    }
}
