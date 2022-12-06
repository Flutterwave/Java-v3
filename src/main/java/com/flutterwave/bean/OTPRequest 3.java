package com.flutterwave.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Cleopatra Douglas
 */
@Getter
@Setter
@NoArgsConstructor
public class OTPRequest extends Shared{

    private Customer customer;
    private String sender;
    private boolean send;
    private int length;
    private int expiry;
    private List<String> medium = new ArrayList<>();

    public OTPRequest(Customer customer, String sender, boolean send, int length,
                      Optional<Integer> expiry, List<Medium> mediumEnum){

        this.customer = customer;
        this.sender = sender;
        this.send = send;
        this.length = length;
        for(Medium value:mediumEnum){
            medium.add(value.name().toLowerCase());
        }
        expiry.ifPresent(integer -> this.expiry = integer);

    }
}
