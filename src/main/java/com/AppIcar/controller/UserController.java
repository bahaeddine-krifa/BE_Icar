package com.AppIcar.controller;

import com.AppIcar.entity.User;
import com.AppIcar.repo.UserRepo;
import com.AppIcar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepo userRepo;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        System.out.println("controller called");
        return ResponseEntity.ok(userService.registerUser(user));
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User userData) {
        User user = userRepo.findByEmail(userData.getEmail());
        if(user.getPassword().equals(userData.getPassword()))
            return ResponseEntity.ok(user);

        return (ResponseEntity<?>) ResponseEntity.internalServerError();
    }

}
