package com.flutterwave.bean;

import java.math.BigDecimal;
import java.util.Optional;

public class FawryPayRequest extends Shared{


    public FawryPayRequest(String tx_ref, BigDecimal amount,
                           String email, String phone_number, String currency,
                           String redirect_url, Optional<Meta> meta){
        this.setTx_ref(tx_ref);
        this.setAmount(amount);
        this.setEmail(email);
        this.setPhone_number(phone_number);
        this.setCurrency(currency);
        this.setRedirect_url(redirect_url);
        meta.ifPresent(this::setMeta);
    }
}
