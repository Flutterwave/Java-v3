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
public class VirtualCardRequest extends Shared{

    private String debit_currency;
    private String first_name;
    private String last_name;
    private String date_of_birth;
    private String phone;
    private  String title;
    private String gender;
    private String callback_url;

    public VirtualCardRequest(String currency, BigDecimal amount, String debit_currency, String billing_name,
                              String billing_address, String billing_city, String billing_state,
                              String billing_postal_code, String billing_country, String first_name,
                              String last_name, String date_of_birth, String email,
                              String phone, String title, String gender, String callback_url){

        this.setCurrency(currency);
        this.setAmount(amount);
        this.debit_currency = debit_currency;
        this.setBilling_name(billing_name);
        this.setBilling_address(billing_address);
        this.setBilling_city(billing_city);
        this.setBilling_state(billing_state);
        this.setBilling_postal_code(billing_postal_code);
        this.setBilling_country(billing_country);
        this.first_name = first_name;
        this.last_name = last_name;
        this.date_of_birth = date_of_birth;
        this.setEmail(email);
        this.phone = phone;
        this.title = title;
        this.gender = gender;
        this.callback_url = callback_url;
    }

}
