package com.flutterwave.services;

import com.flutterwave.bean.CardRequest;
import com.flutterwave.bean.Response;

import java.util.Optional;

import static com.flutterwave.bean.ChargeTypes.CARD;

/**
 * Initiate debit and credit card payments.
 * @author cleopatradouglas
 */
public class CardCharge extends Charge{

    /**
     * Handles card charge requests
     * @param cardRequest bean
     * @return Response
     */
    public Response runTransaction(CardRequest cardRequest){
        return runTransaction(cardRequest.toString(), CARD, true, Optional.empty());
    }
}
