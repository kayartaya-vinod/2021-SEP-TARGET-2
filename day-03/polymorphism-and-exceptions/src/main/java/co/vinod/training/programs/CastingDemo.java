package co.vinod.training.programs;

import co.vinod.training.entity.Circle;
import co.vinod.training.entity.Shape;
import co.vinod.training.entity.Triangle;

public class CastingDemo {
    public static void main(String[] args) {

        Shape shape;

        Circle c1 = new Circle();
        Triangle t1 = new Triangle();

        shape = t1; // upcasting; implicit
        Triangle t2;

        // shape currently refers to an object of Triangle, which as access to setBase() setHeight() ...
        ((Triangle)shape).setBase(12);
        ((Triangle)shape).setHeight(33);

        // this is OK since at this time, shape refers to an instance of Triangle
        t2 = (Triangle) shape; // down-casting; must be explicit

        Circle c2;
        // This is not OK since at this time, shape does not refer to Circle
        if(shape instanceof Circle){
            c2 = (Circle) shape;
        }
    }
}
