package co.vinod.training.programs;

public class ExceptionDemo {

    public static void main(String[] args) {

        try{
            String s1 = args[0];
            String s2 = args[1];
            int n1 = Integer.parseInt(s1);
            int n2 = Integer.parseInt(s2);
            int n3 = n1/n2;
            System.out.printf("quotient of %d divide by %d is %d\n", n1,n2, n3);
        }
        catch(Exception e){
            System.out.println("There was a problem");
            System.out.println("Exception type: " + e.getClass().getName());
            System.out.println("Exception message: " + e.getMessage());
        }


        System.out.println("Program completed successfully!");


    }
}
