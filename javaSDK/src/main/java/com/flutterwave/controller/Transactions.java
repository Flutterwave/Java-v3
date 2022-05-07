package com.flutterwave.controller;

import com.flutterwave.enums.QueryStatus;
import com.flutterwave.services.Connection;
import java.util.Date;

public class Transactions implements Connection {

    private int id;
    private Date from;
    private Date to;
    private String string;
    private String customer_email;
    private QueryStatus status;
    private String tx_ref;
    private String customer_fullname;
    private String currency;

    Transactions(int id){
        this.id = id;
    }

    public String get(){
        return null;
    }

    public String verify(){
        return null;
    }

    public String refund(){
        return null;
    }

    public int getId() {
        return id;
    }

}
