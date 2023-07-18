package com.flutterwave.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class CardRequest extends Shared{

    private String card_number;
    private String country;
    private String cvv;
    private String expiry_month;
    private String expiry_year;
    private Authorization authorization;

   public CardRequest(String card_number,
                      String country,
                      String cvv,
                      String expiry_month,
                      String expiry_year,
                      String currency,
                      BigDecimal amount,
                      String fullname,
                      String email,
                      String tx_ref,
                      String redirect_url,
                      Authorization authorization){

       this.card_number = card_number;
       this.country = country;
       this.cvv = cvv;
       this.expiry_month = expiry_month;
       this.expiry_year = expiry_year;
       this.authorization = authorization;
       this.setCurrency(currency);
       this.setAmount(amount);
       this.setFullname(fullname);
       this.setEmail(email);
       this.setTx_ref(tx_ref);
       this.setRedirect_url(redirect_url);

   }

}
