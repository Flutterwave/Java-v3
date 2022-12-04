package com.flutterwave.services;

import com.flutterwave.bean.Response;
import com.flutterwave.bean.USSDRequest;

import java.util.Optional;

import static com.flutterwave.bean.ChargeTypes.USSD;

/**
 * @author Cleopatra Douglas
 */
public class USSD extends Charge{

    public Response runTransaction(USSDRequest ussdRequest){
        return runTransaction(ussdRequest.toString(), USSD, false, Optional.empty());
    }

}
