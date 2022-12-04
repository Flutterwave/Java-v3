package com.flutterwave.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Card {

    private String first_6digits;
    private String last_4digits;
    private String issuer;
    private String country;
    private String type;
    private String expiry;
}
