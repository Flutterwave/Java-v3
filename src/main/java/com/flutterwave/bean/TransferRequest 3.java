package com.flutterwave.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class TransferRequest extends  Shared{

    private  String callback_url;
    private  String reference;
    private  String debit_currency;

    public TransferRequest(String callback_url, String reference, String debit_currency, String account_bank,
                           String account_number, String narration, BigDecimal amount, String currency){

        this.callback_url = callback_url;
        this.reference = reference;
        this.debit_currency = debit_currency;
        this.setAccount_bank(account_bank);
        this.setAccount_number(account_number);
        this.setNarration(narration);
        this.setAmount(amount);
        this.setCurrency(currency);

    }

}
