package com.flutterwave.services;

import com.flutterwave.bean.FawryPayRequest;
import com.flutterwave.bean.Response;

import java.util.Optional;

import static com.flutterwave.bean.ChargeTypes.FAWRY_PAY;

public class FawryPay extends Charge{

    public Response runTransaction(FawryPayRequest fawryPayRequest){
        return runTransaction(fawryPayRequest.toString(), FAWRY_PAY, false, Optional.empty());
    }
}
