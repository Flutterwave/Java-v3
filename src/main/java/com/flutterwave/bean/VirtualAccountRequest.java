package com.flutterwave.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
public class VirtualAccountRequest extends Shared{
    private String bvn;
    private boolean is_permanent;

    public VirtualAccountRequest(String email, Optional<String> bvn, Optional<BigDecimal> amount, String tx_ref,
                                 Optional<Boolean> is_permanent, String account_name){

        this.setEmail(email);
        this.setNarration(account_name);
        bvn.ifPresent(s -> this.bvn = s);
        this.setTx_ref(tx_ref);
        is_permanent.ifPresent(b -> this.is_permanent = b);
        amount.ifPresent(this::setAmount);
    }
}
