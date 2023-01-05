package com.flutterwave.services;

import com.flutterwave.bean.ListResponse;
import com.flutterwave.bean.Response;
import com.flutterwave.bean.TokenizedChargeRequest;
import com.flutterwave.bean.UpdateTokenRequest;
import java.util.List;
import java.util.Optional;

import static com.flutterwave.bean.ChargeTypes.TOKENIZATION;
import static com.flutterwave.client.Utility.*;
import static com.flutterwave.utility.Properties.getProperty;

/**
 * Manage tokenized transactions.
 * @author Cleopatra Douglas
 */
public class TokenizedCharge {

    /**
     * Intiate a tokenized transactions.
     * @param tokenizedChargeRequest bean
     * @return Response
     */
    public Response runTransaction(TokenizedChargeRequest tokenizedChargeRequest){
        return Optional.of(post(getProperty("TOKENIZED_CHARGE_BASE"), tokenizedChargeRequest.toString(),
                        TOKENIZATION, null))
                .map(Response::toResponse).orElseThrow();
    }

    /**
     * Make multiple tokenized payments at once.
     * @param tokenizedChargeRequestList bean
     * @return Response
     */
    public Response runBulkTransaction(List<TokenizedChargeRequest> tokenizedChargeRequestList){
        return Optional.of(post(getProperty("BULK_TOKENIZED_CHARGE_BASE"), tokenizedChargeRequestList.toString(),
                        TOKENIZATION, null))
                .map(Response::toResponse).orElseThrow();
    }

    /**
     * Get the status of a bulk tokenized charge
     * @param bulk_id int This is the id returned in the bulk charge response
     * @return ListResponse
     */
    public ListResponse runGetBulkTransaction(int bulk_id){
        return Optional.of(get(getProperty("BULK_TOKENIZED_CHARGE_BASE")+bulk_id+"/transactions",
                        TOKENIZATION, null))
                .map(ListResponse::toListResponse).orElseThrow();
    }

    /**
     * This endpoint allows you to query the status of a bulk tokenized charge.
     * @param bulk_id This is the id returned in the bulk charge response
     * @return Response
     */
    public Response runGetBulkTransactionStatus(int bulk_id){
        return Optional.of(get(getProperty("BULK_TOKENIZED_CHARGE_BASE")+bulk_id,
                        TOKENIZATION, null))
                .map(Response::toResponse).orElseThrow();
    }

    /**
     * This endpoints allow developers update the details tied to a customer's card token.
     * @param token String This is the card token returned from the transaction verification endpoint as data.card.token
     * @param updateTokenRequest bean
     * @return Response
     */
    public Response runUpdateToken(String token, UpdateTokenRequest updateTokenRequest){
        return Optional.of(put(getProperty("TOKEN_UPDATE_ENDPOINT")+token, updateTokenRequest.toString(),
                        TOKENIZATION, null))
                .map(Response::toResponse).orElseThrow();
    }
}
