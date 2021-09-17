package co.vinod.training.programs;

import java.io.FileReader;
import java.util.Properties;

public class LoadPropertiesDemo {
    public static void main(String[] args) {
        Properties props = new Properties();
        try (FileReader reader = new FileReader("vinod-info.properties")) {

            props.load(reader);
            System.out.println(props);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
