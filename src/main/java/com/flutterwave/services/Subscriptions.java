package com.flutterwave.services;

import com.flutterwave.bean.Response;
import com.flutterwave.client.Client;

import java.util.Optional;

import static com.flutterwave.bean.Verb.GET;
import static com.flutterwave.client.Utility.put;
import static com.flutterwave.utility.Properties.getProperty;

/**
 * @author Cleopatra Douglas
 */
public class Subscriptions {

    public Response getAllSubscriptions(){
        return Optional.ofNullable(Client.runTransaction(
                        getProperty("SUBSCRIPTION_BASE"),
                        null,
                        GET))
                .map(Response::toResponse).orElseThrow();
    }

    public Response activateSubscription(int id){
        return Optional.of(put(getProperty("SUBSCRIPTION_BASE") + "/" + id + "/activate", null))
                .map(Response::toResponse).orElseThrow();
    }

    public Response deactivateSubscription(int id) {

        return Optional.of(put(getProperty("SUBSCRIPTION_BASE") + "/" + id + "/cancel", null))
                .map(Response::toResponse).orElseThrow();
    }
}
