package co.vinod.training.programs;

import java.util.ResourceBundle;

public class ResourceBundleDemo {
    public static void main(String[] args) {

        // the filename must have an extension of .properties
        // and should be in resources folder (in classpath)
        ResourceBundle rb = ResourceBundle.getBundle("laptop");


        System.out.println("cpu = " + rb.getString("cpu"));
        System.out.println("storage capacity = " + rb.getString("storage.capacity"));

        if(rb.containsKey("hdd"))  {
            System.out.println("hdd = " + rb.getString("hdd"));
        }

    }
}
