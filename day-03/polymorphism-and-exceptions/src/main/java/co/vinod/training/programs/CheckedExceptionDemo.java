package co.vinod.training.programs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CheckedExceptionDemo {

    public static void main(String[] args) {
        String filename = "./src/main/java/co/vinod/training/entity/Phone.java";

        FileReader reader = null;
        BufferedReader in = null;

        try {
            reader = new FileReader(filename);
            in = new BufferedReader(reader);

            String line;

            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            // keep some cleanup code here
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
