package kz.demo.spring_practic1.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    public static ResponseEntity<Object> responseBuilder(String message, HttpStatus status, Object object){
        Map<String,Object> response = new HashMap<>();
        response.put("status",status);
        response.put("data",object);
        response.put("message",message);
        return new ResponseEntity<>(response,status);
    }
}
