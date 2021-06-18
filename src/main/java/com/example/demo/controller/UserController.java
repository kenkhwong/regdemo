package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.RegistrationService;
import com.example.demo.service.UnderAgeException;
import com.example.demo.service.UserExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private RegistrationService registrationService;

    @GetMapping("/users")
    List<User> getUsers(@RequestParam(required = false) String withCreditCard) {
        if (withCreditCard == null)
            return registrationService.getAllUsers();
        if (withCreditCard.equals("Yes"))
            return registrationService.getUsers(true);
        if (withCreditCard.equals("No"))
            return registrationService.getUsers(false);

        return new ArrayList<>();
    }

    @PostMapping("/users")
    ResponseEntity<String> registerUser(@Valid @RequestBody User user)
            throws UserExistsException, UnderAgeException {

        registrationService.registerUser(user);

        try {
            return ResponseEntity.created(new URI("/users"))
                    .build();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
