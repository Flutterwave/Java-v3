package com.flutterwave.services;

import com.flutterwave.bean.ListResponse;
import com.flutterwave.bean.Response;
import com.flutterwave.bean.TransferRequest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static com.flutterwave.client.Utility.get;
import static com.flutterwave.client.Utility.post;
import static com.flutterwave.utility.Properties.getProperty;

public class Transfer {

    public Response runTransaction(TransferRequest transferRequest){
        return Optional.of(post(getProperty("TRANSFER_BASE"), transferRequest.toString()))
                .map(Response::toResponse).orElseThrow();
    }

    public Response runBulkTransaction(List<TransferRequest> transferRequest){
        return Optional.of(post(getProperty("BULK_TRANSFER_ENDPOINT"), transferRequest.toString()))
                .map(Response::toResponse).orElseThrow();
    }

    public Response retry(int id){
        return Optional.of(post(getProperty("TRANSFER_BASE")+id+"/retries", null))
                .map(Response::toResponse).orElseThrow();
    }

    public Response getFee(BigDecimal amount){
        //TODO: add query parameter amount
        return Optional.of(get(getProperty("TRANSFER_FEE_ENDPOINT")))
                .map(Response::toResponse).orElseThrow();
    }

    public Response getTransferRate(BigDecimal amount, String destination_currency, String source_currency){
        //TODO: add query parameter amount
        return Optional.of(get(getProperty("TRANSFER_FEE_ENDPOINT")))
                .map(Response::toResponse).orElseThrow();
    }

    public Response getTransfer(int id){
        return Optional.of(get(getProperty("TRANSFER_BASE")+"/"+id))
                .map(Response::toResponse).orElseThrow();
    }

    public ListResponse getAllTransfers(Optional<String> page, Optional<String> status){
        //TODO: add query parameters
        return Optional.of(get(getProperty("TRANSFER_BASE")))
                .map(ListResponse::toListResponse).orElseThrow();
    }

}
