package com.example.demo.model;

import com.example.demo.constraints.Digits;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Payment extends GenericEntity {

    @NotBlank(message = "Credit card is mandatory")
    @Size(min = 16, max = 16, message = "Credit card must have 16 digits")
    @Digits(message = "Credit card number is invalid")
    private String creditCardNo;

    @NotBlank(message = "Amount is mandatory")
    @Size(min = 3, max = 3, message = "Amount must have 3 digits")
    @Digits(message = "Amount must be a number")
    private String amount;

    public Payment() {}

    public Payment(String creditCardNo, String amount) {
        this.creditCardNo = creditCardNo;
        this.amount = amount;
    }

    public String getCreditCardNo() {
        return creditCardNo;
    }

    public void setCreditCardNo(String creditCardNo) {
        this.creditCardNo = creditCardNo;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
