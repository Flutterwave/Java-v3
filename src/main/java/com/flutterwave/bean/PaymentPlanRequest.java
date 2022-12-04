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
public class PaymentPlanRequest extends  Shared{

    private String interval;
    private  int duration;
    private  String name;

    public  PaymentPlanRequest(BigDecimal amount, String name, String interval, int duration){
        this.setAmount(amount);
        this.name = name;
        this.interval = interval;
        this.duration = duration;
    }
}
