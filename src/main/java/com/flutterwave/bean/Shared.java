package com.flutterwave.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public abstract class Shared {

    private String currency;
    private BigDecimal amount;
    private String fullname;
    private String email;
    private String tx_ref;
    private String redirect_url;
    private String client_ip;
    private String device_fingerprint;
    private String narration;
    private String phone_number;
    private String billing_name;
    private String billing_postal_code;
    private String billing_zip;
    private String billing_city;
    private String billing_address;
    private String billing_state;
    private String billing_country;
    private String account_bank;
    private String account_number;
    private Meta meta;

    @Override
    public String toString() {

        String value = null;
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        try {
            value = objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return value;

    }
}
