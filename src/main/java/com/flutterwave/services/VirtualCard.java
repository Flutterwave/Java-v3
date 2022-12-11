package com.flutterwave.services;

import com.flutterwave.bean.*;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.flutterwave.bean.ChargeTypes.VIRTUAL_CARD;
import static com.flutterwave.client.Utility.get;
import static com.flutterwave.client.Utility.post;
import static com.flutterwave.utility.Properties.getProperty;

/**
 * @author Cleopatra Douglas
 */
public class VirtualCard {

    private String ERROR = "Error processing request, please check logs";

    public Response runCreateVirtualCard(VirtualCardRequest virtualCardRequest){
        return Optional.of(post(getProperty("VIRTUAL_CARD_BASE"), virtualCardRequest.toString(),
                        VIRTUAL_CARD, null))
                .map(Response::toResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }

    public ListResponse runGetAllVirtualCards(){
        return Optional.of(get(getProperty("VIRTUAL_CARD_BASE"),
                        VIRTUAL_CARD, null))
                .map(ListResponse::toListResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }

    public Response runGetVirtualCard(String id){
        return Optional.of(get(getProperty("VIRTUAL_CARD_BASE")+"/"+id,
                        VIRTUAL_CARD, null))
                .map(Response::toResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }

    public Response runFundVirtualCard(String id, FundVirtualCardRequest fundVirtualCardRequest){
        return Optional.of(post(getProperty("VIRTUAL_CARD_BASE")+"/"+id+"/fund",
                        fundVirtualCardRequest.toString(), VIRTUAL_CARD, null))
                .map(Response::toResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }

    public Response runWithdrawVirtualCard(String id,BigDecimal amount){
        return Optional.of(post(getProperty("VIRTUAL_CARD_BASE")+"/"+id+"/withdraw",
                        new JSONObject().put("amount", amount).toString(),
                        VIRTUAL_CARD, null))
                .map(Response::toResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }

    public Response runStatusVirtualCard(String id, Actions actions){
        return Optional.of(post(getProperty("VIRTUAL_CARD_BASE")+"/"
                                +id+"status/"+ actions.name(),
                        null,
                        VIRTUAL_CARD, null))
                .map(Response::toResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }

    public Response runTerminateVirtualCard(String id){
        return Optional.of(post(getProperty("VIRTUAL_CARD_BASE")+"/"
                                +id+"terminate",
                        null,
                        VIRTUAL_CARD, null))
                .map(Response::toResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }

    public ListResponse runGetTransactions(String id, String from, String to, Integer index, Integer size){
        List<NameValuePair> nameValuePairs = new ArrayList<>();
        nameValuePairs.add(new BasicNameValuePair("from", from));
        nameValuePairs.add(new BasicNameValuePair("to", to));
        nameValuePairs.add(new BasicNameValuePair("index", index.toString()));
        nameValuePairs.add(new BasicNameValuePair("size", size.toString()));

        return Optional.of(post(getProperty("VIRTUAL_CARD_BASE")+"/" +id,
                        null, VIRTUAL_CARD, nameValuePairs))
                .map(ListResponse::toListResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }
}
