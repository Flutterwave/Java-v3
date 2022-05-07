package com.flutterwave.controller;

import com.flutterwave.bean.RequestBean;

public class VirtualAccounts {

    private String reference;
    private String batchID;
    private String bvn;

    VirtualAccounts(String reference){
        this.reference = reference;
    }

    VirtualAccounts(String batchID, String bvn){
        this.batchID = batchID;
        this.bvn = bvn;
    }

    public String create(RequestBean request){
        return null;
    }

    public String createBulk(RequestBean request){
        return null;
    }

    public String getAccountNumber(){
        return null;
    }

    public String updateBVN(){
        return null;
    }

    public String delete(){
        return null;
    }

    public String getBulkAccountNumbers(){
        return null;
    }
}
