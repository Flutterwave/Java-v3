package com.flutterwave.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

import static com.flutterwave.bean.AuthorizationModes.AUS_NOAUTH;
import static com.flutterwave.bean.AuthorizationModes.PIN;

@Getter
@Setter
@NoArgsConstructor
public class Authorization {

    private String transfer_reference;
    private String transfer_account;
    private String transfer_bank;
    private  String account_expiration;
    private String transfer_note;
    private BigDecimal transfer_amount;
    private String mode;
    private String note;
    private String account_number;
    private String sort_code;
    private String redirect;
    private String instruction;
    private String validate_instructions;
    private String city;
    private String address;
    private String state;
    private String country;
    private String zipcode;

    private String pin;
    private List<String> fields;

    public Authorization pinAuthorization(String pin){
        this.pin = pin;
        this.mode = PIN.name().toLowerCase();
        return this;
    }

    public Authorization avsAuthorization(String city, String address, String state, String country, String zipcode){
        this.mode = AUS_NOAUTH.toString().toLowerCase();
        this.city = city;
        this.address = address;
        this.state = state;
        this.country = country;
        this.zipcode = zipcode;
        return this;
    }

    public AuthorizationModes getMode(){
        return  AuthorizationModes.valueOf(this.mode.toUpperCase());
    }

}
