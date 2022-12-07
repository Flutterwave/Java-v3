package com.flutterwave.services;

import com.flutterwave.bean.ChargeTypes;
import com.flutterwave.bean.Request;
import com.flutterwave.bean.Response;
import com.flutterwave.client.Client;

import java.util.Optional;

import static com.flutterwave.bean.Verb.POST;
import static com.flutterwave.utility.Properties.getProperty;

public abstract class Charge {
    /**
     * Handles all charge requests
     * @param request json string with request
     * @param type of transaction charge
     * @return Response which represents FLUTTERWAVE's JSON responses
     */
    public Response runTransaction(String request, ChargeTypes type, boolean encrypyt, Optional<String> urlSuffix){
        return Optional.ofNullable(Client.runTransaction(
                        getProperty("CHARGE_BASE")+(urlSuffix.isEmpty() ?"?type="+type.toString().toLowerCase() : urlSuffix),
                        encrypyt?new Request(request).toString():request,
                        POST, type, null))
                .map(Response::toResponse).orElseThrow(() -> new RuntimeException("Error processing request, please check logs"));
    }
}
