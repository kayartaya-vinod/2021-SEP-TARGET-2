package co.vinod.training.model;

public class Person { // same as "class Person extends Object"
    private String name;
    private int age;
    private double height;
    // aggregation
    private Address address = new Address();

    // when this class does not have any constructors,
    // then a no-argument constructor is given by default by the compiler.

    public Person(){
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, int age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 0 && age <= 150) {
            this.age = age;
        }
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        if (height >= 0 && height <= 8.0) {
            this.height = height;
        }
    }
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    // write your own toString() to textually represent an object
    @Override
    public String toString() {
        return "Object of Person (" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", address=" + address +
                ')';
    }

    public void print() {
        System.out.println("Name   = " + name);
        System.out.println("Age    = " + age + " years");
        System.out.println("Height = " + height + " ft.");
        System.out.println();
    }
}
