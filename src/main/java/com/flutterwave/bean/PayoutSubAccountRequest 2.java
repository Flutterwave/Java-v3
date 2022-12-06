package com.flutterwave.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * @author Cleopatra Douglas
 */
@Getter
@Setter
@NoArgsConstructor
public class PayoutSubAccountRequest extends  Shared{

    private String mobilenumber;
    private String country;

    public PayoutSubAccountRequest(String email, String mobilenumber, String country, Optional<String> account_name){

        this.setEmail(email);
        this.mobilenumber = mobilenumber;
        this.country = country;
        account_name.ifPresent(this::setAccount_name);


    }
}
