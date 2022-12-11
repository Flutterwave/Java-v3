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
 * @author Cleopatra Douglas
 */
public class TokenizedCharge {

    public Response runTransaction(TokenizedChargeRequest tokenizedChargeRequest){
        return Optional.of(post(getProperty("TOKENIZED_CHARGE_BASE"), tokenizedChargeRequest.toString(),
                        TOKENIZATION, null))
                .map(Response::toResponse).orElseThrow();
    }

    public Response runBulkTransaction(List<TokenizedChargeRequest> tokenizedChargeRequestList){
        return Optional.of(post(getProperty("BULK_TOKENIZED_CHARGE_BASE"), tokenizedChargeRequestList.toString(),
                        TOKENIZATION, null))
                .map(Response::toResponse).orElseThrow();
    }

    public ListResponse runGetBulkTransaction(int bulk_id){
        return Optional.of(get(getProperty("BULK_TOKENIZED_CHARGE_BASE")+bulk_id+"/transactions",
                        TOKENIZATION, null))
                .map(ListResponse::toListResponse).orElseThrow();
    }

    public Response runGetBulkTransactionStatus(int bulk_id){
        return Optional.of(get(getProperty("BULK_TOKENIZED_CHARGE_BASE")+bulk_id,
                        TOKENIZATION, null))
                .map(Response::toResponse).orElseThrow();
    }

    public Response runUpdateToken(String token, UpdateTokenRequest updateTokenRequest){
        return Optional.of(put(getProperty("TOKEN_UPDATE_ENDPOINT")+token, updateTokenRequest.toString(),
                        TOKENIZATION, null))
                .map(Response::toResponse).orElseThrow();
    }
}
