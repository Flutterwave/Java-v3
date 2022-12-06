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
public class PreAuthorizationRequest extends Shared{

    private String card_number;
    private String cvv;
    private String expiry_month;
    private String expiry_year;
    private String country;
    private String redirect_url;
    private boolean preauthorize = true;

    public PreAuthorizationRequest(String card_number, String cvv, String expiry_month, String expiry_year,
                                   BigDecimal amount, String fullname, String tx_ref, String currency, String country,
                                   String email, String redirect_url, Optional<Meta> meta){


        this.card_number = card_number;
        this.cvv = cvv;
        this.expiry_month = expiry_month;
        this.expiry_year = expiry_year;
        this.setAmount(amount);
        this.setFullname(fullname);
        this.setTx_ref(tx_ref);
        this.setCurrency(currency);
        this.country = country;
        this.setEmail(email);
        this.setRedirect_url(redirect_url);
        meta.ifPresent(this::setMeta);
    }

}
