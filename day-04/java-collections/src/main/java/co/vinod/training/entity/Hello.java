package co.vinod.training.entity;

@FunctionalInterface
public interface Hello {
    public void sayHello(String name);

    default public void bye() {
    }

    default public void hi() {
    }
}

// an interface which has exactly one abstract function is called as functional interface.
// and arrow functions can be used only for function interfaces.