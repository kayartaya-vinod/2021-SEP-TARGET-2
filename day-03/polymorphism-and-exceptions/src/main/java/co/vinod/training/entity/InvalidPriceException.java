package co.vinod.training.entity;

public class InvalidPriceException extends Exception {
    public InvalidPriceException() {
    }

    public InvalidPriceException(String message) {
        super(message);
    }

    public InvalidPriceException(Throwable cause) {
        super(cause);
    }
}
