package com.kvinod.training.programs;

public class Variables {

    public static void main(String[] args) {

        double price = 12499.99;
        int quantity = 3;
        boolean isSmart = true;


        String name = "Redmi Note 4";

        System.out.println("Name     = " + name);
        System.out.println("Price    = ₹ " + price);
        System.out.printf("Quantity = %d units\n", quantity);

        if (isSmart) {
            System.out.printf("%s is a smartphone\n", name);
        }
        else {
            System.out.printf("%s is not a smartphone\n", name);
        }

        if(price<=5000){
            System.out.printf("%s is a low-priced phone\n", name);
        }
        else if(price>=15000){
            System.out.printf("%s is a high-priced phone\n", name);
        }
        else {
            System.out.printf("%s is a properly priced phone", name);
        }
    }
}
