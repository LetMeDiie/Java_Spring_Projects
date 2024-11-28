package kz.letmedie.paste.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class PasteResponse {
    public static ResponseEntity<Object> responseBuilder(String message, HttpStatus status, Object object) {
        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("status", status.value());
        response.put("message", message);
        response.put("data", object != null ? object : "Данные отсутствуют");
        return new ResponseEntity<>(response, status);
    }
}
