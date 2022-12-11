package com.flutterwave.services;

import com.flutterwave.bean.PaypalRequest;
import com.flutterwave.bean.Response;

import java.util.Optional;

import static com.flutterwave.bean.ChargeTypes.PAYPAL;

public class Paypal extends Charge{

    public Response runTransaction(PaypalRequest paypalRequest){
        return runTransaction(paypalRequest.toString(), PAYPAL, false, Optional.empty());
    }
}
