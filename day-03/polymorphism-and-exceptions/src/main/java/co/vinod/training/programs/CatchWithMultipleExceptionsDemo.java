package co.vinod.training.programs;

import java.util.Arrays;

public class CatchWithMultipleExceptionsDemo {

    public static void main(String[] args) {

        try{
            String s1 = args[0];
            String s2 = args[1];
            int n1 = Integer.parseInt(s1);
            int n2 = Integer.parseInt(s2);
            int n3 = n1/n2;
            System.out.printf("quotient of %d divide by %d is %d\n", n1,n2, n3);
        }
        catch(ArrayIndexOutOfBoundsException | NumberFormatException e){
            System.out.println("Expected 2 integers, got " + Arrays.toString(args) );
        }
        catch(ArithmeticException e){
            System.out.println("Cannot divide " + args[0] + " by zero");
        }
        catch(Exception e){
            System.out.println("Something went wrong!");
            e.printStackTrace();
        }


        System.out.println("Program completed successfully!");


    }
}
