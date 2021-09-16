package co.vinod.training.programs;

import co.vinod.training.entity.Hello;

public class ArrowFunctionDemo {

    static void greet(String name, Hello hello) {
        hello.sayHello(name);
    }

    public static void main(String[] args) {

        Hello h;

        h = new Hello() {
            @Override
            public void sayHello(String name) {
                System.out.printf("Hello %s!\n", name);
            }
        };

        h.sayHello("Vinod");
        greet("Vinay", h);

        greet("Vijay", new Hello() {
            @Override
            public void sayHello(String name) {
                System.out.println("Hello " + name + ", Welcome to Bangalore!");
            }
        });

        greet("Arun", (name) -> System.out.println("Hey " + name + ", How are you?"));

        greet("Suneel", (name)->System.out.println(name));
        // following work, only if the abstract function in the functional interface has a single parameter
        greet("Suneel", System.out::println); // here :: is called method reference operator
        greet("Sujay", ArrowFunctionDemo::printInUpperCase);

    }

    static void printInUpperCase(String str){
        System.out.println(str.toUpperCase());
    }
}
