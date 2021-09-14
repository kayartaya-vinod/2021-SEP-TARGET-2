package co.vinod.training.programs;

import co.vinod.training.model.Person;
import co.vinod.training.model.Product;

public class AbstractionDemo {

    public static void main(String[] args) {

        Person p1 = new Person();

        p1.setName("Vinod");
        p1.setAge(48);
        p1.setHeight(5.8);

        p1.getAddress().setStreet("1st cross 1st main");
        p1.getAddress().setArea("ISRO layout");
        p1.getAddress().setCity("Bangalore");
        p1.getAddress().setStreet("Karnataka");

        p1.print();

        System.out.println(p1);
        System.out.printf("%s is %d years old and %.2f ft. tall\n", p1.getName(), p1.getAge(), p1.getHeight());

    }
}
