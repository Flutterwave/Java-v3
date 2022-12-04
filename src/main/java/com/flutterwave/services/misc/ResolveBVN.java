package com.flutterwave.services.misc;

import com.flutterwave.bean.Response;
import com.flutterwave.client.Client;

import java.util.Optional;

import static com.flutterwave.bean.Verb.GET;
import static com.flutterwave.utility.Properties.getProperty;

public class ResolveBVN {

    public Response runTransaction(String bvn){
        return Optional.ofNullable(Client.runTransaction(
                        getProperty("BVN_RESOLVE_ENDPOINT")+bvn,
                        null,
                        GET))
                .map(Response::toResponse).orElseThrow();
    }
}
