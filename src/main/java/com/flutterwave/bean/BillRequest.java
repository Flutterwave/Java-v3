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
    private String type;
    private String reference;


    public BillRequest(String country, String customer, BigDecimal amount, String type, String reference,
                       Optional<Recurrence> recurrence, Optional<GhanaAirtimeBills> ghanaAirtimeBills) {

        this.country = country;
        this.type = type;
        this.reference = reference;
        this.customer = customer;
        this.setAmount(amount);
        recurrence.ifPresent(value -> this.recurrence = String.valueOf(value));
        ghanaAirtimeBills.ifPresent(s -> this.biller_name = s.name());
    }

}
