package com.flutterwave.controller;

import com.flutterwave.enums.MISC;
import com.flutterwave.services.Connection;

public class Misc implements Connection {

    private String currency;
    private String bin;
    private String bvn;
    private MISC misc;

    Misc(String value, boolean isCurrency, boolean isBvn, MISC misc){
        if(isCurrency){
            this.currency = value;
        }else if(isBvn){
            this.bvn = value;
        }else{
            this.bin = value;
        }

        this.misc = misc;

    }

    public String handle() {
        switch (misc) {
            case single_wallet_balances:
                return getSingleWalletBalance();
            case bulk_wallet_balances:
                return getBulkWalletBalance();
            case account_resolve:
                return accountResolve();
            case bvn:
                return checkBVN();
            case card_bin:
                return checkCardBin();
            case statement:
                return getStatement();
            default:
                return null;
        }
    }

    private String getSingleWalletBalance(){
            return null;
   }

    private String getStatement(){
        return null;
    }

    private String getBulkWalletBalance(){
        return null;
    }

    private String accountResolve(){
        return null;
    }

    private String checkBVN(){
        return null;
    }

    private String checkCardBin(){
        return null;
    }

}
