package com.example.demo.service;

import com.example.demo.jpa.UserRepository;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Service
public class RegistrationService {

    private static final int ageLimit = 18;

    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<User> getUsers(boolean withCreditCard) {
        if (withCreditCard)
            return userRepository.findByCreditCardNoNotNull();
        else
            return userRepository.findByCreditCardNoIsNull();
    }

    public List<User> findUsersByCreditCard(String cardNo) {
        return userRepository.findByCreditCardNo(cardNo);
    }

    @Transactional
    public void registerUser(User user) throws UnderAgeException, UserExistsException {
        //check the user age
        if (Period.between(user.getDateOfBirth(),LocalDate.now()).getYears() < ageLimit)
            throw new UnderAgeException();

        //check existing users
        if (userRepository.findByUsername(user.getUsername()).isPresent())
            throw new UserExistsException();

        userRepository.save(user);
    }
}
