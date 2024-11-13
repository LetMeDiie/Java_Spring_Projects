package kz.demo.spring_practic1.service.impl;

import kz.demo.spring_practic1.exception.exceptions.UserExistingEmailException;
import kz.demo.spring_practic1.exception.exceptions.UserNotFoundException;
import kz.demo.spring_practic1.model.Status;
import kz.demo.spring_practic1.model.User;
import kz.demo.spring_practic1.repository.UserRepository;
import kz.demo.spring_practic1.response.ResponseHandler;
import kz.demo.spring_practic1.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public ResponseEntity<Object> saveUser(User user) {
        if(userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new UserExistingEmailException("there is user with same email");
        }
        long id = userRepository.save(user).getId();
        return ResponseHandler.responseBuilder("user was saved", HttpStatus.OK,id);
    }

    @Override
    public ResponseEntity<Object>  findUserById(Long id){
        if(userRepository.findById(id).isEmpty()) {
            throw new UserNotFoundException("User does not exist");
        }
        User user = userRepository.findById(id).get();
        return ResponseHandler.responseBuilder("user was find", HttpStatus.OK,user);
    }

    @Override
    public ResponseEntity<Object> updateUser(Long id) {
        User user = userRepository.findById(id).get();
        Status status = user.getStatus();
        Map<String,String> updateResponse = new HashMap<>();
        updateResponse.put("id",user.getId().toString());
        updateResponse.put("previous status",status.toString());
        status = status==Status.ONLINE?Status.OFFLINE:Status.ONLINE;
        updateResponse.put("current status",status.toString());
        user.setStatus(status);
        userRepository.save(user);
        return ResponseHandler.responseBuilder("user was update", HttpStatus.OK,updateResponse);
    }
}
