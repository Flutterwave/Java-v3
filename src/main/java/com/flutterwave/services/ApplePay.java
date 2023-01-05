package com.flutterwave.services;

import com.flutterwave.bean.ApplePayRequest;
import com.flutterwave.bean.Response;

import java.util.Optional;

import static com.flutterwave.bean.ChargeTypes.APPLEPAY;

/**
 * @author Cleopatra Douglas
 * This payment method allows you to accept payments from your customers via Apple Pay.
 */
public class ApplePay extends Charge{

    /**
     * Handles ApplePay requests
     * @param applePayRequest bean
     * @return Response
     */
    public Response runTransaction(ApplePayRequest applePayRequest){
        return runTransaction(applePayRequest.toString(), APPLEPAY, false, Optional.empty());
    }
}
