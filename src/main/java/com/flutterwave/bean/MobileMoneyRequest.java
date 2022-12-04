package com.flutterwave.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MobileMoneyRequest extends Shared{

    private String voucher;
    private String network;
    private String country;
}
