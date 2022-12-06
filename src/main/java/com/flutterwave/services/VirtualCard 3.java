package com.flutterwave.services;

import com.flutterwave.bean.ListResponse;
import com.flutterwave.bean.Response;
import com.flutterwave.bean.VirtualCardRequest;

import java.util.Optional;

import static com.flutterwave.client.Utility.get;
import static com.flutterwave.client.Utility.post;
import static com.flutterwave.utility.Properties.getProperty;

/**
 * @author Cleopatra Douglas
 */
public class VirtualCard {

    public Response runCreateVirtualCard(VirtualCardRequest virtualCardRequest){
        return Optional.of(post(getProperty("VIRTUAL_CARD_BASE"), virtualCardRequest.toString()))
                .map(Response::toResponse).orElseThrow();
    }

    public ListResponse getAllVirtualCards(){
        return Optional.of(get(getProperty("VIRTUAL_CARD_BASE")))
                .map(ListResponse::toListResponse).orElseThrow();
    }

    public Response getVirtualCard(String id){
        return Optional.of(get(getProperty("VIRTUAL_ACCOUNT_BASE")+"/"+id))
                .map(Response::toResponse).orElseThrow();
    }
}
