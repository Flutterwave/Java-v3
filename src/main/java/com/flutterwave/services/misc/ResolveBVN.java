package com.flutterwave.services.misc;

import com.flutterwave.bean.Response;
import com.flutterwave.client.Client;

import java.util.Optional;

import static com.flutterwave.bean.ChargeTypes.RESOLVE_BVN;
import static com.flutterwave.bean.Verb.GET;
import static com.flutterwave.utility.Properties.getProperty;

public class ResolveBVN {

    private String ERROR = "Error processing request, please check logs";

    public Response runTransaction(String bvn){
        return Optional.ofNullable(Client.runTransaction(
                        getProperty("BVN_RESOLVE_ENDPOINT")+bvn,
                        null,
                        GET,
                        RESOLVE_BVN,
                        null))
                .map(Response::toResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }
}
