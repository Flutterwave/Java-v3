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
public class UpdateSubAccountRequest extends  Shared{

    private int id;
    private BigDecimal split_value;
    private String business_name;
    private String business_email;
    private String split_type;

    public UpdateSubAccountRequest(int id, BigDecimal split_value, Optional<String> business_name,
                                   Optional<String> business_email, Optional<String> split_type,Optional<String> account_number ){
        this.id = id;
        split_type.ifPresent(s -> this.split_type = s);
        this.split_value = split_value;
        business_name.ifPresent(s -> this.business_name = s);
        account_number.ifPresent(this::setAccount_number);
        business_email.ifPresent(s -> this.business_email = s);

    }

}
