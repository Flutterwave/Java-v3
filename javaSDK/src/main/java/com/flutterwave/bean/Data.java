package com.flutterwave.bean;

import java.math.BigDecimal;

public class Data {

    private int id;
    private String tx_ref;
    private String flw_ref;
    private String device_fingerprint;
    private BigDecimal amount;
    private BigDecimal charged_amount;
    private BigDecimal app_fee;
    private BigDecimal merchant_fee;
    private String processor_response;
    private String auth_model;
    private String currency;
    private String ip;
    private String narration;
    private String status;
    private String auth_url;
    private String payment_type;
    private String fraud_status;
    private String charge_type;
    private String created_at;
    private int account_id;
    private Customer customer;
    private Card card;
    private Meta Meta;
}
