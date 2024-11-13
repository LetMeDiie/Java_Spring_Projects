package kz.demo.spring_practic1.service;

import kz.demo.spring_practic1.model.User;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface UserService {
    ResponseEntity<Object> saveUser(User user);
    ResponseEntity<Object>  findUserById(Long id);
    ResponseEntity<Object> updateUser(Long id);
}
