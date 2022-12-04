package com.flutterwave.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class MpesaRequest extends MobileMoneyRequest {

    public MpesaRequest(String tx_ref, BigDecimal amount, String currency, String email, String phone_number, String fullname){
        this.setTx_ref(tx_ref);
        this.setAmount(amount);
        this.setCurrency(currency);
        this.setEmail(email);
        this.setPhone_number(phone_number);
        this.setFullname(fullname);
    }

}
