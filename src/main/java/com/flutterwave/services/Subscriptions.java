package com.flutterwave.services;

import com.flutterwave.bean.ListResponse;
import com.flutterwave.bean.Response;
import com.flutterwave.client.Client;

import java.util.Optional;

import static com.flutterwave.bean.ChargeTypes.SUBSCRIPTION;
import static com.flutterwave.bean.Verb.GET;
import static com.flutterwave.client.Utility.put;
import static com.flutterwave.utility.Properties.getProperty;

/**
 * @author Cleopatra Douglas
 */
public class Subscriptions {
    private String ERROR = "Error processing request, please check logs";

    public ListResponse getAllSubscriptions(){
        return Optional.ofNullable(Client.runTransaction(
                        getProperty("SUBSCRIPTION_BASE"),
                        null,
                        GET,
                        SUBSCRIPTION,
                        null))
                .map(ListResponse::toListResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }

    public Response activateSubscription(int id){
        return Optional.of(put(getProperty("SUBSCRIPTION_BASE") + "/" + id + "/activate",
                        null, SUBSCRIPTION, null))
                .map(Response::toResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }

    public Response deactivateSubscription(int id) {

        return Optional.of(put(getProperty("SUBSCRIPTION_BASE") + "/" + id + "/cancel",
                        null, SUBSCRIPTION, null))
                .map(Response::toResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }
}
