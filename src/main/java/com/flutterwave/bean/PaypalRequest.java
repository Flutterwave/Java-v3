package com.flutterwave.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
public class PaypalRequest extends Shared{

    private String shipping_name;
    private String shipping_address;
    private String shipping_city;
    private String shipping_zip;
    private String shipping_state;
    private String shipping_country;

    public PaypalRequest(String fullname, String shipping_name, String shipping_address, String shipping_city, String shipping_zip,
                         String shipping_state, String shipping_country,
                         String tx_ref, BigDecimal amount,
                         String email, String phone_number, String currency,
                         String client_ip, String device_fingerprint, String billing_zip,
                         String billing_city, String billing_address, String billing_state,
                         String billing_country, String redirect_url, Optional<Meta> meta){
        this.shipping_address = shipping_address;
        this.shipping_country = shipping_country;
        this.shipping_state = shipping_state;
        this.shipping_city = shipping_city;
        this.shipping_zip = shipping_zip;
        this.shipping_name = shipping_name;
        this.setFullname(fullname);
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
        this.setRedirect_url(redirect_url);
        meta.ifPresent(this::setMeta);
    }
}
