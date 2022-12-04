package com.flutterwave.services;

import com.flutterwave.bean.ApplePayRequest;
import com.flutterwave.bean.Response;

import java.util.Optional;

import static com.flutterwave.bean.ChargeTypes.APPLEPAY;

public class ApplePay extends Charge{

    public Response runTransaction(ApplePayRequest applePayRequest){
        return runTransaction(applePayRequest.toString(), APPLEPAY, false, Optional.empty());
    }
}
