package kz.letmedie.paste.exception;

public class HashingException extends RuntimeException {
    public HashingException(String message, Throwable cause) {
        super(message, cause);
    }

    public HashingException(String message) {
        super(message);
    }
}
