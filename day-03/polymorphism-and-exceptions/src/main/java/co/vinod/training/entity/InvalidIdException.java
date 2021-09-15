package co.vinod.training.entity;

public class InvalidIdException extends Exception{
    public InvalidIdException() {
    }

    public InvalidIdException(String message) {
        super(message);
    }

    public InvalidIdException(Throwable cause) {
        super(cause);
    }
}
