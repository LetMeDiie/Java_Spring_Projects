package kz.demo.spring_practic1.controller;

import kz.demo.spring_practic1.model.User;
import kz.demo.spring_practic1.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("/{userId}")
    public ResponseEntity<Object> getUser(@PathVariable String userId){
        return userService.findUserById(Long.parseLong(userId));
    }

    @PostMapping
    public ResponseEntity<Object> addUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<Object> updateUser(@PathVariable String userId){
        return userService.updateUser(Long.parseLong(userId));
    }
}
