package co.vinod.training.programs;

import java.util.Set;
import java.util.TreeSet;

public class SetDemo {

    public static void main(String[] args) {
        Set<String> names = new TreeSet<>();
        names.add("Vinod");
        names.add("Vinod");
        names.add("Vishal");
        names.add("Ramesh");
        names.add("Arun");
        names.add("Anil");
        names.add("Vishal");
        names.add("Vishal");
        names.add("Kishore");
        names.add("Vishal");
        names.add("Kiran");

        System.out.println(names);
    }
}
