package com.flutterwave.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class BillSummary {

    private String currency;
    private BigDecimal sum_bills;
    private BigDecimal sum_commission;
    private BigDecimal sum_dstv;
    private BigDecimal sum_airtime;
    private BigDecimal count_dstv;
    private BigDecimal count_airtime;

}
