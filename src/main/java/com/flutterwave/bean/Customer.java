package com.flutterwave.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Customer extends Shared{

    private int id;
    private String created_at;
    private String name;
    private String phone;

    public Customer(String name, String email, String phone){
        this.name = name;
        this.setEmail(email);
        this.phone = phone;
    }

}
