package kz.letmedie.catalogue.exception.exceptionHandlers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
@RequiredArgsConstructor
public class BadRequestControllerAdvice {
    @ExceptionHandler(BindException.class)
    public ResponseEntity<ProblemDetail> handleBindException(BindException bindException){
        ProblemDetail problemDetail=
                ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST,"Error 404");
        problemDetail.setProperty("errors",
                bindException.getAllErrors().stream()
                        .map(ObjectError::getDefaultMessage)
                        .toList());
        return ResponseEntity.badRequest().body(problemDetail);

    }
}
