package com.flutterwave.services;

import com.flutterwave.bean.ListResponse;
import com.flutterwave.bean.Response;
import com.flutterwave.bean.TransferRequest;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.flutterwave.bean.ChargeTypes.TRANSFER;
import static com.flutterwave.client.Utility.get;
import static com.flutterwave.client.Utility.post;
import static com.flutterwave.utility.Properties.getProperty;

public class Transfer {

    private String ERROR = "Error processing request, please check logs";

    public Response runTransaction(TransferRequest transferRequest){
        return Optional.of(post(getProperty("TRANSFER_BASE"), transferRequest.toString(),
                        TRANSFER, null))
                .map(Response::toResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }

    public Response runBulkTransaction(List<TransferRequest> transferRequest){
        return Optional.of(post(getProperty("BULK_TRANSFER_ENDPOINT"), transferRequest.toString(),
                        TRANSFER, null))
                .map(Response::toResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }

    public Response retry(int id){
        return Optional.of(post(getProperty("TRANSFER_BASE")+id+"/retries",
                        null, TRANSFER, null))
                .map(Response::toResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }

    public Response getFee(BigDecimal amount){
        List<NameValuePair> nameValuePairs = new ArrayList<>();
        nameValuePairs.add(new BasicNameValuePair("amount", amount.toString()));

        return Optional.of(get(getProperty("TRANSFER_FEE_ENDPOINT"),TRANSFER, nameValuePairs))
                .map(Response::toResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }

    public Response getTransferRate(BigDecimal amount, String destination_currency, String source_currency){
        List<NameValuePair> nameValuePairs = new ArrayList<>();
        nameValuePairs.add(new BasicNameValuePair("amount", amount.toString()));
        nameValuePairs.add(new BasicNameValuePair("destination_currency", destination_currency));
        nameValuePairs.add(new BasicNameValuePair("source_currency", source_currency));

        return Optional.of(get(getProperty("TRANSFER_FEE_ENDPOINT"), TRANSFER, nameValuePairs))
                .map(Response::toResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }

    public Response getTransfer(int id){
        return Optional.of(get(getProperty("TRANSFER_BASE")+"/"+id, TRANSFER, null))
                .map(Response::toResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }

    public ListResponse getAllTransfers(Optional<String> page, Optional<String> status){
        List<NameValuePair> nameValuePairs = new ArrayList<>();
        page.ifPresent(s -> nameValuePairs.add(new BasicNameValuePair("page", s)));
        status.ifPresent(s -> nameValuePairs.add(new BasicNameValuePair("status", s)));

        return Optional.of(get(getProperty("TRANSFER_BASE"), TRANSFER, nameValuePairs))
                .map(ListResponse::toListResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }

}
