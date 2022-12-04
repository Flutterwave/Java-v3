package com.flutterwave.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
public class BillRequest extends Shared {

    private String biller_name;
    private String recurrence;
    private String country;
    private String customer;


    public BillRequest(String country, String customer, BigDecimal amount,
                       Optional<Recurrence> recurrence, Optional<String> ghanaAirtimeBills) {

        this.country = country;
        this.customer = customer;
        this.setAmount(amount);
        recurrence.ifPresent(value -> this.recurrence = String.valueOf(value));
        ghanaAirtimeBills.ifPresent(s -> this.biller_name = s);
    }

}
