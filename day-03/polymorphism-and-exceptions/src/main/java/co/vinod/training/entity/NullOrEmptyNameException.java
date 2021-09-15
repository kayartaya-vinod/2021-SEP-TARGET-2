package co.vinod.training.entity;

public class NullOrEmptyNameException extends Exception {
    public NullOrEmptyNameException() {
    }

    public NullOrEmptyNameException(String message) {
        super(message);
    }

    public NullOrEmptyNameException(Throwable cause) {
        super(cause);
    }
}
