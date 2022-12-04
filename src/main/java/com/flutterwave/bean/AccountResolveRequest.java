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
public class AccountResolveRequest extends Shared{

    private String type;
    private String country;

    public AccountResolveRequest(String account_number, String account_bank,
                                 Optional<ChargeTypes> type, Optional<String> country){

        this.setAccount_number(account_number);
        this.setAccount_bank(account_bank);
        type.ifPresent(chargeTypes -> this.type = chargeTypes.toString());
        country.ifPresent(s -> this.country = s);

    }
}
