package com.flutterwave.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class BankAccountRequest extends Shared{

    public BankAccountRequest(String tx_ref, BigDecimal amount, String account_bank, String account_number,
                              String currency, String email, String phone_number, String fullname){

        this.setTx_ref(tx_ref);
        this.setAmount(amount);
        this.setAccount_bank(account_bank);
        this.setAccount_number(account_number);
        this.setCurrency(currency);
        this.setEmail(email);
        this.setPhone_number(phone_number);
        this.setFullname(fullname);

    }

}
