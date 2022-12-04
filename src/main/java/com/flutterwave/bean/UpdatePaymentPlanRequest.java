package com.flutterwave.bean;

import java.math.BigDecimal;

/**
 * @author Cleopatra Douglas
 */
public class UpdatePaymentPlanRequest extends  Shared{

    private String status;

    public UpdatePaymentPlanRequest(String status, BigDecimal amount){
        this.setAmount(amount);
        this.status = status;
    }
}
