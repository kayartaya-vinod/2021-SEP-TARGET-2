package co.vinod.training.programs;

import co.vinod.training.entity.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsDemo {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();

        people.add(new Person("Vinod", "Delhi", 48, 5.8));
        people.add(new Person("Vinod", "Bangalore", 29, 5.2));
        people.add(new Person("Vinod", "Mysore", 29, 5.5));
        people.add(new Person("Vishal", "Bangalore", 30, 5.10));
        people.add(new Person("Vinod", "Shivamogga", 48, 5.8));
        people.add(new Person("Arun", "Chennai", 48, 5.8));
        people.add(new Person("Ramesh", "Bangalore", 48, 5.6));

        people.stream()
                .filter((p) -> p.getAge() >= 40) // filtering
                .map((p) -> p.getName())         // converting/ transforming
                .forEach((name) -> System.out.println(name)); // .forEach(System.out::println)

        System.out.println();

        List<String> names = people.stream()
                .map(p -> p.getName())
                .map(String::toUpperCase)
                .distinct()
                .collect(Collectors.toList());

        System.out.println("names = " + names);
    }

}
