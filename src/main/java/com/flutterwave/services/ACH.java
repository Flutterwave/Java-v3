package com.flutterwave.services;

import com.flutterwave.bean.ACHRequest;
import com.flutterwave.bean.Response;

import java.util.Optional;

import static com.flutterwave.bean.ChargeTypes.ACH_PAYMENT;

/**
 * Handles ACH charge payments
 */
public class ACH extends Charge{
    public Response runTransaction(ACHRequest achRequest){
        return runTransaction(achRequest.toString(), ACH_PAYMENT, false, Optional.empty());
    }

}
