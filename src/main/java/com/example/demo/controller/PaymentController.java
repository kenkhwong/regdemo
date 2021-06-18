package com.example.demo.controller;

import com.example.demo.model.Payment;
import com.example.demo.service.RegistrationService;
import com.example.demo.service.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class PaymentController {

    @Autowired
    RegistrationService registrationService;

    @PostMapping("/payments")
    ResponseEntity<String> makePayment(@Valid @RequestBody Payment payment)
            throws UserNotFoundException {

        if (registrationService.findUsersByCreditCard(payment.getCreditCardNo())
            .isEmpty()) throw new UserNotFoundException();

        return ResponseEntity.created(null).build();
    }
}
