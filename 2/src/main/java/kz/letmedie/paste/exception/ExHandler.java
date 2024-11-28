package kz.letmedie.paste.exception;
import kz.letmedie.paste.api.PasteResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ExHandler {
    @ExceptionHandler(PasteNotFoundException.class)
    public ResponseEntity<Object> handlePasteNotFoundException(PasteNotFoundException ex) {
        return PasteResponse.responseBuilder(
                ex.getMessage(),
                HttpStatus.NOT_FOUND,
                null
        );
    }

    @ExceptionHandler(PasteExpiredException.class)
    public ResponseEntity<Object> handlePasteExpiredException(PasteExpiredException ex) {
        return PasteResponse.responseBuilder(
                ex.getMessage(),
                HttpStatus.GONE,
                null
        );
    }

    @ExceptionHandler(HashingException.class)
    public ResponseEntity<Object> handleHashingException(HashingException ex) {
        return PasteResponse.responseBuilder(
                ex.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR,
                null
        );
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException ex, WebRequest request) {
        return PasteResponse.responseBuilder(
                ex.getMessage(),
                HttpStatus.BAD_REQUEST,
                null
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGeneralException(Exception ex) {
        return PasteResponse.responseBuilder(
                "Error",
                HttpStatus.INTERNAL_SERVER_ERROR,
                ex.getMessage()
        );
    }
}
