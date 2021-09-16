package co.vinod.training.programs;

import co.vinod.training.entity.Person;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class HashSetOfPersonsDemo {
    public static void main(String[] args) {
        Set<Person> people = new TreeSet<>();

        Person p;

        p = new Person("Vinod", "Bangalore", 48, 5.8);
        System.out.println("p.hashCode() is " + p.hashCode());
        people.add(p);

        p = new Person("Vinod", "Bangalore", 29, 5.8);
        System.out.println("p.hashCode() is " + p.hashCode());
        people.add(p);

        p = new Person("Vinod", "Bangalore", 29, 5.5);
        System.out.println("p.hashCode() is " + p.hashCode());
        people.add(p);
        p = new Person("Vishal", "Bangalore", 30, 5.10);
        System.out.println("p.hashCode() is " + p.hashCode());
        people.add(p);
        p = new Person("Vinod", "Shivamogga", 48, 5.8);
        System.out.println("p.hashCode() is " + p.hashCode());
        people.add(p);
        p = new Person("Arun", "Chennai", 48, 5.8);
        System.out.println("p.hashCode() is " + p.hashCode());
        people.add(p);
        p = new Person("Ramesh", "Bangalore", 48, 5.8);
        System.out.println("p.hashCode() is " + p.hashCode());
        people.add(p);

        printPeopleInfo(people);
    }

    static void printPeopleInfo(Set<Person> data) {
        System.out.printf("Size = %d\n", data.size());
        // jdk 1.4 and prior
        Iterator<Person> it = data.iterator();
        while (it.hasNext()) {
            Person p = it.next();
            System.out.println(p);
        }
        System.out.println();
    }
}
