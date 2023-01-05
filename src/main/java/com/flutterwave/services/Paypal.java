package com.flutterwave.services;

import com.flutterwave.bean.PaypalRequest;
import com.flutterwave.bean.Response;

import java.util.Optional;

import static com.flutterwave.bean.ChargeTypes.PAYPAL;

/**
 * This payment method allows you to collect payments via PayPal.
 * @author cleopatradouglas
 */
public class Paypal extends Charge{

    /**
     * Handles Paypal requests
     * @param paypalRequest bean
     * @return Response
     */
    public Response runTransaction(PaypalRequest paypalRequest){
        return runTransaction(paypalRequest.toString(), PAYPAL, false, Optional.empty());
    }
}
