package com.example.demo.model;

import com.example.demo.constraints.Alphanumeric;
import com.example.demo.constraints.ContainsDigit;
import com.example.demo.constraints.ContainsUpperCase;
import com.example.demo.constraints.Digits;

import javax.persistence.Entity;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
public class User extends GenericEntity {

    @NotBlank(message = "Username is mandatory")
    @Alphanumeric(message = "Username must be alphanumeric")
    private String username;

    @NotBlank(message = "Password is mandatory")
    @Size(min = 8, message = "Password must have at least 8 characters")
    @ContainsUpperCase(message = "Password must have at least one upper case letter")
    @ContainsDigit(message = "Password must have at least one digit")
    private String password;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email is invalid")
    private String email;

    @NotNull(message = "Date of birth is mandatory")
    private LocalDate dateOfBirth;

    @Size(min = 16, max = 16, message = "Credit card must have 16 digits")
    @Digits(message = "Credit card number is invalid")
    private String creditCardNo;

    public User() {}

    public User(String username, String password, String email, LocalDate dateOfBirth, String creditCardNo) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.creditCardNo = creditCardNo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCreditCardNo() {
        return creditCardNo;
    }

    public void setCreditCardNo(String creditCardNo) {
        this.creditCardNo = creditCardNo;
    }
}
