package com.flutterwave.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author Cleopatra Douglas
 */
@Getter
@Setter
@NoArgsConstructor
public class USSDRequest extends Shared{

    public USSDRequest(String tx_ref, String account_bank, BigDecimal amount, String currency, String email, String phone_number,
                       String fullname){
       this.setTx_ref(tx_ref);
       this.setAccount_bank(account_bank);
       this.setAmount(amount);
       this.setCurrency(currency);
       this.setEmail(email);
       this.setPhone_number(phone_number);
       this.setFullname(fullname);
    }
}
