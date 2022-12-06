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
public class UpdatePaymentPlanRequest extends  Shared{

    private String status;
    private String name;

    public UpdatePaymentPlanRequest(String status, String name){
        this.name = name;
        this.status = status;
    }
}
