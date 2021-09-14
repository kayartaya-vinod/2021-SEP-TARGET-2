package co.vinod.training.programs;

import co.vinod.training.model.Person;

public class ConstructorDemo {
    public static void main(String[] args) {

        Person p1 = new Person();
        Person p2 = new Person("Vinod");
        Person p3 = new Person("Vinod", 48, 5.8);

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
    }
}
