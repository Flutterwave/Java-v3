package com.flutterwave.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
public class ACHRequest extends Shared{

    private String country;

    public ACHRequest(String tx_ref, BigDecimal amount,
                      String email, String phone_number, String currency, String country,
                      String client_ip, String fullname, String redirect_url, String device_fingerprint, Optional<Meta> meta){
        this.setTx_ref(tx_ref);
        this.setAmount(amount);
        this.setEmail(email);
        this.setPhone_number(phone_number);
       this.country = country;
       this.setFullname(fullname);
        this.setCurrency(currency);
        this.setClient_ip(client_ip);
        this.setRedirect_url(redirect_url);
        this.setDevice_fingerprint(device_fingerprint);
        meta.ifPresent(this::setMeta);
    }

}
