package com.flutterwave.controller;

import com.flutterwave.services.Connection;

public class Validate implements Connection {

    public String validate(String reference, boolean isCard, boolean autoOTP, String OTP){

        if(autoOTP) {
            OTP = generateOTP();
        }

        if(isCard){
            return null;
        }else {
            return null;
        }
    }

    @Override
    public String send(String request, String URL) {
        return null;
    }

    private String generateOTP(){
        return null;
    }
}
