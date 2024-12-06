package org.example.showcase.api.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(InvalidTaskRequestException.class)
    public ResponseEntity<ErrorDetails> handleInvalidTaskRequestException(InvalidTaskRequestException exception){
        ErrorDetails errorDetails = new ErrorDetails("Invalid task request", exception.getMessage());
        return ResponseEntity
                .badRequest().
                body(errorDetails);
    }

    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleTaskNotFoundException(TaskNotFoundException exception){
        ErrorDetails errorDetails = new ErrorDetails("Task not found",exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(errorDetails);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleAllExceptions(Exception exception) {
        ErrorDetails errorDetails = new ErrorDetails("Server Error", exception.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDetails);
    }

}
