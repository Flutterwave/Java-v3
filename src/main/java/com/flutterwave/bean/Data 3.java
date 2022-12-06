package com.flutterwave.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class Data {

    private Customer customer;
    private int id;
    private String tx_ref;
    private String flw_ref;
    private String device_fingerprint;
    private BigDecimal amount;
    private BigDecimal charged_amount;
    private BigDecimal app_fee;
    private BigDecimal fee;
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
    private Card card;
    private  String type;
    private Account account;
    private boolean redirect;
    private String redirect_url;
    private String payment_code;
    private String type_data;
    private String order_ref;
    private String biller_code;
    private String default_commission;
    private String name;
    private String branch_code;
    private String branch_name;
    private String swift_code;
    private String bank_id;
    private String bic;
    private String date_added;
    private String country;
    private boolean is_airtime;
    private boolean is_active;
    private String biller_name;
    private String item_code;
    private String label_name;
    private String short_name;
    private boolean commission_on_fee;
    private String card_pan;
    private String masked_pan;
    private String city;
    private String state;
    private String address_1;
    private String address_2;
    private String zip_code;
    private String cvv;
    private String expiration;
    private String send_to;
    private String bin_check_name;
    private String card_type;
    private String name_on_card;
    private String callback_url;
    private String interval;
    private int duration;
    private String plan_token;
    private String code;
    private String customer_name;
    private String customer_email;
    private String settlement_id;
    private String transaction_id;
    private String meta;
    private String subaccount_id;
    private String bank_name;
    private String split_type;
    private BigDecimal split_value;
    private int split_ratio;
    private BigDecimal amount_settled;
    private BigDecimal amount_refunded;
}
