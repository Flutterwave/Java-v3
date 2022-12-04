package com.flutterwave.services;

import com.flutterwave.bean.CardRequest;
import com.flutterwave.bean.Response;

import java.util.Optional;

import static com.flutterwave.bean.ChargeTypes.CARD;

public class CardCharge extends Charge{

    public Response runTransaction(CardRequest cardRequest){
        return runTransaction(cardRequest.toString(), CARD, true, Optional.empty());
    }
}
