package co.vinod.training.entity;

public class DaoException extends Exception{
    public DaoException() {
    }

    public DaoException(String message) {
        super(message);
    }

    public DaoException(Throwable cause) {
        super(cause);
    }
}
