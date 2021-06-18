package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegistrationService {

    private static final int ageLimit = 18;

    private final List<User> registeredUsers = new ArrayList<>();

    public List<User> getAllUsers() {
        return List.copyOf(registeredUsers);
    }

    public List<User> getUsers(boolean withCreditCard) {
        return registeredUsers.stream().filter(user ->
                (withCreditCard && user.getCreditCardNo() != null)
                        || (!withCreditCard && user.getCreditCardNo() == null))
                .collect(Collectors.toList());
    }

    public List<User> findUsersByCreditCard(String cardNo) {
        return registeredUsers.stream().filter(user ->
                user.getCreditCardNo() != null && user.getCreditCardNo().equals(cardNo))
                .collect(Collectors.toList());
    }

    public void registerUser(User user) throws UnderAgeException, UserExistsException {
        //check the user age
        if (Period.between(user.getDateOfBirth(),LocalDate.now()).getYears() < ageLimit)
            throw new UnderAgeException();

        //check existing users
        for (User existingUser : registeredUsers) {
            if (existingUser.getUsername().equals(user.getUsername()))
                throw new UserExistsException();
        }

        registeredUsers.add(user);
    }
}
