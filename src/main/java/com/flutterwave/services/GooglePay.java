package com.flutterwave.services;

import com.flutterwave.bean.GooglePayRequest;
import com.flutterwave.bean.Response;

import java.util.Optional;

import static com.flutterwave.bean.ChargeTypes.GOOGLEPAY;

/**
 * This payment method allows you to accept payments from your customers via Google Pay.
 * @author cleopatradouglas
 */
public class GooglePay extends Charge{

    /**
     * Handles googlepay requests
     * @param googlePayRequest bean
     * @return Response
     */
    public Response runTransaction(GooglePayRequest googlePayRequest){
        return runTransaction(googlePayRequest.toString(), GOOGLEPAY, false, Optional.empty());
    }
}
