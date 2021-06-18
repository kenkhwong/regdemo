package com.example.demo.jpa;

import com.example.demo.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends GenericRepository<User> {

    Optional<User> findByUsername(String username);

    List<User> findByCreditCardNoIsNull();

    List<User> findByCreditCardNoNotNull();

    List<User> findByCreditCardNo(String cardNo);
}
