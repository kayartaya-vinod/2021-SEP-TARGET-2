package co.vinod.training.programs;

public class StringDemo {

    public static void main(String[] args) {

        String s1 = "Vinod"; // String class maintains a cache (called, intern) to store the strings
        // If, "Vinod" is already in the cache, it's reference is retrieved and assigned to s1.
        // Since it is not there, a new String object is created, stored in cache, and it's reference is
        // given to s1.

        String s2 = "Vinod"; // Since "Vinod" is already in cache, it's reference is assigned to s2.
        System.out.println("s1==s2 is " + (s1 == s2)); // checks for references and not values

        String s3 = new String("Vinod"); // a new String constructed using the value of a String "Vinod" which
        // is already there in the cache.
        System.out.println("s1==s3 is " + (s1 == s3));
        System.out.println("s2==s3 is " + (s2 == s3));

        System.out.println("s1 is " + s1);
        System.out.println("s2 is " + s2);
        System.out.println("s3 is " + s3);

        System.out.println("s1.equals(s2) is "+ s1.equals(s2));
        System.out.println("s1.equals(s3) is "+ s1.equals(s3));
        System.out.println("s2.equals(s3) is "+ s2.equals(s3));

        s1 += " Kumar"; // s1 = s1 + " Kumar"
    }
}
