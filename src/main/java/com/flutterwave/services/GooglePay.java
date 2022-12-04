package com.flutterwave.services;

import com.flutterwave.bean.GooglePayRequest;
import com.flutterwave.bean.Response;

import java.util.Optional;

import static com.flutterwave.bean.ChargeTypes.GOOGLEPAY;

public class GooglePay extends Charge{

    public Response runTransaction(GooglePayRequest googlePayRequest){
        return runTransaction(googlePayRequest.toString(), GOOGLEPAY, false, Optional.empty());
    }
}
