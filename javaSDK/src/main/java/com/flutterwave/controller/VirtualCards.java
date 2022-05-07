package com.flutterwave.controller;

import com.flutterwave.bean.RequestBean;
import com.flutterwave.enums.VirtualCardActions;
import java.math.BigDecimal;
import java.util.Date;

public class VirtualCards {

    private int id;

    VirtualCards(int id){
        this.id = id;
    }

    private Date from;
    private Date to;
    private int index;
    private int size;

    VirtualCards(Date from, Date to, int index, int size){
        this.from = from;
        this.to = to;
        this.index = index;
        this.size = size;
    }

    public String create(RequestBean request){
        return null;
    }

    public String getAll(RequestBean request){
        return null;
    }

    public String get(){
        return null;
    }

    public String fund(RequestBean request){
        return null;
    }

    public String withdraw(BigDecimal amount){
        return null;
    }

    public String getTransactions(){
        return null;
    }

    public String action(VirtualCardActions action){
        return null;
    }


}
