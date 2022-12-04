package com.flutterwave.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
public class BanKTransferRequest extends Shared{

    private boolean is_permanent;
    private Integer expires;

    public BanKTransferRequest(Optional<Boolean> is_permanent, String tx_ref, Optional<BigDecimal> amount,
                               String email, Optional<String> phone_number, String currency,
                               String client_ip, String device_fingerprint, String narration, Optional<Integer> expires){
        is_permanent.ifPresent(aBoolean -> this.is_permanent = aBoolean);
        expires.ifPresent(integer -> this.expires = integer);
        this.setTx_ref(tx_ref);
        amount.ifPresent(this::setAmount);
        this.setEmail(email);
        phone_number.ifPresent(this::setPhone_number);
        this.setCurrency(currency);
        this.setClient_ip(client_ip);
        this.setDevice_fingerprint(device_fingerprint);
        this.setNarration(narration);
    }
}
