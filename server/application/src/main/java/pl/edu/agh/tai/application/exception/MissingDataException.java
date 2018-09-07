package pl.edu.agh.tai.application.exception;

public class MissingDataException extends RuntimeException{

    public MissingDataException(){
        super();
    }

    public MissingDataException(String message) {
        super(message);
    }

    public MissingDataException(Throwable cause) {
        super(cause);
    }
}
