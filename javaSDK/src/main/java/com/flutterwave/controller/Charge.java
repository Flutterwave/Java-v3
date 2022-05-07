package com.flutterwave.controller;

import com.flutterwave.bean.RequestBean;
import com.flutterwave.enums.ChargeTypes;
import com.flutterwave.services.Connection;

/**
 * Handles all charge cases
 */
public class Charge implements Connection {

    public String charge(RequestBean request, ChargeTypes type, boolean preauthorize){

        switch (type) {
            case card:
                return cardCharge(request, preauthorize);
            case mobile_money_franco:
            case mobile_money_ghana:
            case mobile_money_rwanda:
            case mobile_money_uganda:
            case mobile_money_zambia:
            case mpesa:
                return mobileMoneyCharge(request);
            case ach_payment:
                return achCharge(request);
            case bank_transfer:
                return bankTransfer(request);
            case paypal:
                return paypalCharge(request, preauthorize);
            case debit_ng_account:
                return debitNGNAccount(request);
            case debit_uk_account:
                return debitUKAccount(request);
            case ussd:
                return ussdCharge(request);
            case tokenized_charge:
                return tokenizedCharge(request);
            case bulk_tokenized_charge:
                return bulkTokenizedCharge(request);
            case capture:
                return capture(request);
            case voiD:
                return voiD(request);
            default:
                return null;
        }
    }


    private String cardCharge(RequestBean request, boolean preauthorize){
        return null;
    }

    private String mobileMoneyCharge(RequestBean request){
        return null;
    }

    private String achCharge(RequestBean request){
        return null;
    }

    private String ussdCharge(RequestBean request){
        return null;
    }

    private String bankTransfer(RequestBean request){
        return null;
    }

    private String capture(RequestBean request){
        return null;
    }

    private String voiD(RequestBean request){
        return null;
    }

    private String paypalCharge(RequestBean request, boolean preauthorize){
        return null;
    }

    private String debitNGNAccount(RequestBean request){
        return null;
    }

    private String debitUKAccount(RequestBean request){
        return null;
    }

    private String tokenizedCharge(RequestBean request){
        return null;
    }

    private String bulkTokenizedCharge(RequestBean request){
        return null;
    }

}
