package kz.letmedie.paste.exception;

public class PasteNotFoundException extends RuntimeException{
    public PasteNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public PasteNotFoundException(String message) {
        super(message);
    }
}
