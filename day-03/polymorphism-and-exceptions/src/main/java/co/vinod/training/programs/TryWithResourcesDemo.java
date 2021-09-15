package co.vinod.training.programs;

import co.vinod.training.entity.Dummy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResourcesDemo {

    public static void main(String[] args) {
        String filename = "./src/main/java/co/vinod/training/entity/Phone.java";

        try (
                Dummy d = new Dummy();
        ) {
            System.out.println("inside the try block");
            int n = 123/0;
            System.out.println("this line is skipped");
        } // in.close() and reader.close() gets automatically called here
        catch (Exception e) {
            System.out.println("inside the catch block");
        }
    }
}
