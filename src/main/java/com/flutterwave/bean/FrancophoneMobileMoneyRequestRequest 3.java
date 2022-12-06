package com.flutterwave.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class FrancophoneMobileMoneyRequestRequest extends MobileMoneyRequest {

    public FrancophoneMobileMoneyRequestRequest(String tx_ref, BigDecimal amount, String country, String currency, String email, String phone_number, String fullname){
        this.setTx_ref(tx_ref);
        this.setAmount(amount);
        this.setCurrency(currency);
        this.setCountry(country);
        this.setEmail(email);
        this.setPhone_number(phone_number);
        this.setFullname(fullname);
    }

}
