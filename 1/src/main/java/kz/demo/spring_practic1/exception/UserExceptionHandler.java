package kz.demo.spring_practic1.exception;

import kz.demo.spring_practic1.exception.exceptions.UserExistingEmailException;
import kz.demo.spring_practic1.exception.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionHandler{
    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<UserException> handleUserNotFoundException(UserNotFoundException exception) {
        UserException userException = new UserException(
                exception.getMessage(),
                exception,
                HttpStatus.NOT_FOUND
        );
        return new ResponseEntity<>(userException, userException.getStatus());
    }


    @ExceptionHandler(value = UserExistingEmailException.class)
    public ResponseEntity<UserException> handleUserExitingEmailException(
            UserExistingEmailException userExistingEmailException){
        UserException userException = new UserException(
                userExistingEmailException.getMessage(),
                userExistingEmailException.getCause(),
                HttpStatus.CONFLICT
        );
        return new ResponseEntity<>(userException,userException.getStatus());
    }
}


