package com.flutterwave.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * @author Cleopatra Douglas
 */
@Getter
@Setter
@NoArgsConstructor
public class UpdatePayoutSubAccountRequest extends  PayoutSubAccountRequest{

    public UpdatePayoutSubAccountRequest(Optional<String> email, Optional<String> mobilenumber, Optional<String> account_name){

        account_name.ifPresent(this::setAccount_name);
        mobilenumber.ifPresent(this::setMobilenumber);
        email.ifPresent(this::setEmail);


    }

}
