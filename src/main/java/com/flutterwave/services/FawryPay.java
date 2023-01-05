package com.flutterwave.services;

import com.flutterwave.bean.FawryPayRequest;
import com.flutterwave.bean.Response;

import java.util.Optional;

import static com.flutterwave.bean.ChargeTypes.FAWRY_PAY;

/**
 * Collect payments from customers via Fawry.
 * @author cleopatradouglas
 */
public class FawryPay extends Charge{

    /**
     * Handles FawryPay requests
     * @param fawryPayRequest bean
     * @return Response
     */
    public Response runTransaction(FawryPayRequest fawryPayRequest){
        return runTransaction(fawryPayRequest.toString(), FAWRY_PAY, false, Optional.empty());
    }
}
