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

    /**
     * Create A Virtual Card
     * @param virtualCardRequest bean
     * @return Response
     */
    public Response runCreateVirtualCard(VirtualCardRequest virtualCardRequest){
        return Optional.of(post(getProperty("VIRTUAL_CARD_BASE"), virtualCardRequest.toString(),
                        VIRTUAL_CARD, null))
                .map(Response::toResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }

    /**
     * This fetches all virtual cards created by the User
     * @return ListResponse
     */
    public ListResponse runGetAllVirtualCards(){
        return Optional.of(get(getProperty("VIRTUAL_CARD_BASE"),
                        VIRTUAL_CARD, null))
                .map(ListResponse::toListResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }

    /**
     * This call gets a specific virtual card by ID created by the User with id
     * @param id String This is the id of the virtual card to be fetched. You can get this id from the call to create a virtual card or list virtual cards as data.id
     * @return Response
     */
    public Response runGetVirtualCard(String id){
        return Optional.of(get(getProperty("VIRTUAL_CARD_BASE")+"/"+id,
                        VIRTUAL_CARD, null))
                .map(Response::toResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }

    /**
     * This funds a specific virtual card.
     * @param id String This is the id of the virtual card to be fetched. You can get this id from the call to create a virtual card or list virtual cards as data.id
     * @param fundVirtualCardRequest bean
     * @return Response
     */
    public Response runFundVirtualCard(String id, FundVirtualCardRequest fundVirtualCardRequest){
        return Optional.of(post(getProperty("VIRTUAL_CARD_BASE")+"/"+id+"/fund",
                        fundVirtualCardRequest.toString(), VIRTUAL_CARD, null))
                .map(Response::toResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }

    /**
     * This withdraws existing funds from a virtual card
     * @param id String This is the id of the virtual card to be fetched. You can get this id from the call to create a virtual card or list virtual cards as data.id
     * @param amount BigDecimal This is the amount to be withdrawn
     * @return Response
     */
    public Response runWithdrawVirtualCard(String id,BigDecimal amount){
        return Optional.of(post(getProperty("VIRTUAL_CARD_BASE")+"/"+id+"/withdraw",
                        new JSONObject().put("amount", amount).toString(),
                        VIRTUAL_CARD, null))
                .map(Response::toResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }

    /**
     * This call blocks or unblocks a virtual card created by the User.
     * @param id String This is the id of the virtual card to be fetched. You can get this id from the call to create a virtual card or list virtual cards as data.id
     * @param actions Actions This is the action you want to perform on the virtual card. Can be block or unblock
     * @return Response
     */
    public Response runStatusVirtualCard(String id, Actions actions){
        return Optional.of(post(getProperty("VIRTUAL_CARD_BASE")+"/"
                                +id+"status/"+ actions.name(),
                        null,
                        VIRTUAL_CARD, null))
                .map(Response::toResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }

    /**
     * This call terminates a virtual card created by the User.
     * @param id String This is the id of the virtual card to be fetched. You can get this id from the call to create a virtual card or list virtual cards as data.id
     * @return Response
     */
    public Response runTerminateVirtualCard(String id){
        return Optional.of(post(getProperty("VIRTUAL_CARD_BASE")+"/"
                                +id+"terminate",
                        null,
                        VIRTUAL_CARD, null))
                .map(Response::toResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }

    /**
     * This call fetches transactions by date range on a single card
     * @param id String This is the id of the virtual card to be fetched. You can get this id from the call to create a virtual card or list virtual cards as data.id
     * @param from String This is the start date of the transaction request period
     * @param to String This is the end date of the transaction request period
     * @param index Integer Pass 0 if you want to start from the beginning
     * @param size Integer Specify how many transactions you want to retrieve in a single call
     * @return ListResponse
     */
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
