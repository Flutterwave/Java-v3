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
public class FundVirtualCardRequest extends Shared{

    private String debit_currency;

    public FundVirtualCardRequest(String debit_currency, BigDecimal amount){
        this.debit_currency = debit_currency;
        this.setAmount(amount);
    }

}
