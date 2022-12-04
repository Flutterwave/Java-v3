package com.flutterwave.bean;

import java.math.BigDecimal;
import java.util.Optional;

public class GooglePayRequest extends Shared{

    public GooglePayRequest(String tx_ref, BigDecimal amount,
                            String email, String phone_number, String currency,
                            String client_ip, String device_fingerprint, String billing_zip,
                            String billing_city, String billing_address, String billing_state,
                            String billing_country, String narration, Optional<Meta> meta){
        this.setTx_ref(tx_ref);
        this.setAmount(amount);
        this.setEmail(email);
        this.setPhone_number(phone_number);
        this.setCurrency(currency);
        this.setClient_ip(client_ip);
        this.setDevice_fingerprint(device_fingerprint);
        this.setBilling_address(billing_address);
        this.setBilling_city(billing_city);
        this.setBilling_zip(billing_zip);
        this.setBilling_state(billing_state);
        this.setBilling_country(billing_country);
        this.setNarration(narration);
        meta.ifPresent(this::setMeta);
    }
}
