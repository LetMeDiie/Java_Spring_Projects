package kz.demo.spring_practic1.exception.exceptions;

public class UserExistingEmailException extends RuntimeException {
    public UserExistingEmailException(String message) {
        super(message);
    }

    public UserExistingEmailException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
