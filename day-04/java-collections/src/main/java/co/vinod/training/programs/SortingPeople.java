package co.vinod.training.programs;

import co.vinod.training.entity.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingPeople {

    static class AgeComparator implements Comparator<Person> {
        @Override
        public int compare(Person p1, Person p2) {
            return p1.getAge() <= p2.getAge() ? -1 : 1;
        }
    }

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();

        people.add(new Person("Vinod", "Delhi", 48, 5.8));
        people.add(new Person("Vinod", "Bangalore", 29, 5.2));
        people.add(new Person("Vinod", "Mysore", 29, 5.5));
        people.add(new Person("Vishal", "Bangalore", 30, 5.10));
        people.add(new Person("Vinod", "Shivamogga", 48, 5.8));
        people.add(new Person("Arun", "Chennai", 48, 5.8));
        people.add(new Person("Ramesh", "Bangalore", 48, 5.6));

        printListContent(people);
        Collections.sort(people); // mutates the collection; uses natural ordering
        printListContent(people);
        Collections.sort(people, new AgeComparator()); // we are supplying an object consisting of a logic (in a function)
        // because, in Java we cannot supply function as a argument!
        printListContent(people);

        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.getHeight() <= p2.getHeight() ? -1 : 1;
            }
        });
        printListContent(people);

        Collections.sort(people, (p1, p2) -> p1.getCity().compareTo(p2.getCity()) <= 0 ? -1 : 1);
        printListContent(people);

    }

    static void printListContent(List<? extends Object> data) {
        // jdk 1.5 onwards; just a wrapper on Iterator
        for (Object obj : data) {
            System.out.println(obj);
        }
        System.out.println();
    }
}
