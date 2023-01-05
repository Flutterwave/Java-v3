package com.flutterwave.services;

import com.flutterwave.bean.ACHRequest;
import com.flutterwave.bean.Response;

import java.util.Optional;

import static com.flutterwave.bean.ChargeTypes.ACH_PAYMENT;

/**
 * @author Cleopatra Douglas
 * This payment method allows you to collect USD and ZAR payments via ACH
 */
public class ACH extends Charge{

    /**
     * Handles ACH requests
     * @param achRequest bean
     * @return Response
     */
    public Response runTransaction(ACHRequest achRequest){
        return runTransaction(achRequest.toString(), ACH_PAYMENT, false, Optional.empty());
    }

}
