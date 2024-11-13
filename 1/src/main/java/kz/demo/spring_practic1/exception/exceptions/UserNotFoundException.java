package kz.demo.spring_practic1.exception.exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message){
        super(message);
    }
    public UserNotFoundException(String message,Throwable throwable){
        super(message,throwable);
    }
}
