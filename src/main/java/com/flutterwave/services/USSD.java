package com.flutterwave.services;

import com.flutterwave.bean.Response;
import com.flutterwave.bean.USSDRequest;

import java.util.Optional;

import static com.flutterwave.bean.ChargeTypes.USSD;

/**
 * This method allows you to generate USSD strings for payments.
 * @author Cleopatra Douglas
 */
public class USSD extends Charge{

    /**
     * Handles USSD transactions
     * @param ussdRequest bean
     * @return Response
     */
    public Response runTransaction(USSDRequest ussdRequest){
        return runTransaction(ussdRequest.toString(), USSD, false, Optional.empty());
    }

}
