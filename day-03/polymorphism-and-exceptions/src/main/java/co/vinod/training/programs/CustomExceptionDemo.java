package co.vinod.training.programs;

import co.vinod.training.entity.InvalidIdException;
import co.vinod.training.entity.InvalidPriceException;
import co.vinod.training.entity.NullOrEmptyNameException;
import co.vinod.training.entity.Product;

public class CustomExceptionDemo {

    public static void main(String[] args) {

        Product p;
        p = new Product();

        try {
            p.setId(0);
            p.setName("Magic mouse");
            p.setPrice(8000.0);
            System.out.println(p);
        } catch (InvalidIdException e) {
            System.out.println("Not a valid id");
        } catch (NullOrEmptyNameException e) {
            System.out.println("Did you forget to type in name?");
        } catch (InvalidPriceException e) {
            System.out.println("Price must be between 0 and 2 Million");
        }
    }
}
