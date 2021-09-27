package co.vinod.training;

public class FactorialException extends Exception{
    public FactorialException() {
    }

    public FactorialException(String message) {
        super(message);
    }

    public FactorialException(Throwable cause) {
        super(cause);
    }
}
