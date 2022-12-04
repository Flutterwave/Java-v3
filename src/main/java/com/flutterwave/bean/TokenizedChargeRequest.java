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
public class TokenizedChargeRequest extends Shared{

    private String token;
    private String country;
    private String first_name;
    private String last_name;
    private String ip;

    public TokenizedChargeRequest(String token, String country, String currency, BigDecimal amount,
                                  String email, String first_name, String last_name,
                                  String ip, String narration, String tx_ref){

        this.token = token;
        this.country = country;
        this.setCurrency(currency);
        this.setAmount(amount);
        this.setEmail(email);
        this.first_name = first_name;
        this.last_name = last_name;
        this.ip = ip;
        this.setNarration(narration);
        this.setTx_ref(tx_ref);

    }
}
