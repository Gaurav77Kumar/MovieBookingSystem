package src.exception;

public class BookingFailedException extends RuntimeException{
    public BookingFailedException(String message){
        super(message);
    }
}
