package com.example.demo.controller;

import com.example.demo.jpa.PaymentRepository;
import com.example.demo.model.Payment;
import com.example.demo.service.RegistrationService;
import com.example.demo.service.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;

@RestController
public class PaymentController {

    @Autowired
    RegistrationService registrationService;
    @Autowired
    PaymentRepository paymentRepository;

    @PostMapping("/payments")
    ResponseEntity<String> makePayment(@Valid @RequestBody Payment payment)
            throws UserNotFoundException {

        if (registrationService.findUsersByCreditCard(payment.getCreditCardNo())
            .isEmpty()) throw new UserNotFoundException();

        paymentRepository.save(payment);

        return ResponseEntity.created(URI.create("/payments")).build();
    }
}
