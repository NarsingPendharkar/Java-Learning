package example.exception;

public class InvalidUserDetailsException extends  Exception{

    public InvalidUserDetailsException(String errorMessage){
        super(errorMessage);
    }
}
