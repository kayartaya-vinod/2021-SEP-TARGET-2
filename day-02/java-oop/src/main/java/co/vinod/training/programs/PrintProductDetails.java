package co.vinod.training.programs;

import co.vinod.training.model.Product;

public class PrintProductDetails {
    public static void main(String[] args) {
        Product p1; // just a reference variable; not initialized; class Product not in VM yet.

        p1 = new Product(); // p1 refers to an object of Product class
        // new instructs the VM to allocate memory for an object of type Product.
        // this requires the class to be searched and loaded into VM.
        // once in VM, an estimate of the no.of bytes required in the heap is calculated,
        // and such memory is reserved in the heap.

        p1.id = 1246;
        p1.price = 499.99;
        p1.name = "Mouse"; // 5 chars --> 10 bytes; same as new String("Mouse")

        Product p2;

        p2 = p1;
        p2.id = 228;

        p1.name = null;

        printProduct(p1);
        printProduct(p2);

        System.out.println("p1 == p2 is " + (p1==p2));

        Product p3 = new Product();
        Product p4 = new Product();
        printProduct(p3);
        printProduct(p4);
        System.out.println("p3 == p4 is " + (p3==p4)); // to check values, use p3.equals(p4)

    }

    static void printProduct(Product product) {
        if (product == null) return;

        System.out.println("ID     = " + product.id);
        System.out.println("Name   = " + product.name);
        System.out.println("Price  = ₹ " + product.price);
        System.out.println();
    }
}
