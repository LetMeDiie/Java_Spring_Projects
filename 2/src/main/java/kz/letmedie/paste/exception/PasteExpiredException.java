package kz.letmedie.paste.exception;


public class PasteExpiredException extends RuntimeException {
    public PasteExpiredException(String message) {
        super(message);
    }

    public PasteExpiredException(String message, Throwable cause) {
        super(message, cause);
    }
}