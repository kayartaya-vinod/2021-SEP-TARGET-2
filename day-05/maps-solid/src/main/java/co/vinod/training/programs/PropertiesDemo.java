package co.vinod.training.programs;

import java.io.FileWriter;
import java.util.Properties;

public class PropertiesDemo {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.setProperty("name", "Vinod Kumar");
        props.setProperty("website", "https://vinod.co");
        props.setProperty("email", "vinod@vinod.co");
        props.setProperty("phone", "9731424784");

        try (FileWriter writer = new FileWriter("vinod-info.properties")) {

            props.store(writer, "Created by Kumar");
            System.out.println(props);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
