package com.flutterwave.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Optional;

/**
 * @author Cleopatra Douglas
 */
@Getter
@Setter
@NoArgsConstructor
public class BeneficiaryRequest extends Shared{

    private String beneficiary_name;
    private String bank_name;

    public BeneficiaryRequest(String account_number, String account_bank, String beneficiary_name,
                              Optional<String> currency, Optional<String> bank_name){
        this.beneficiary_name = beneficiary_name;
        this.setAccount_bank(account_bank);
        this.setAccount_number(account_number);
        currency.ifPresent(this::setCurrency);
        bank_name.ifPresent(s -> this.bank_name = s);
    }

}
