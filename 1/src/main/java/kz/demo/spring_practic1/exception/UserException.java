package kz.demo.spring_practic1.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Data
public class UserException {
    private final String message;
    private final Throwable throwable;
    private final HttpStatus status;

}
