package com.flutterwave.services;

import com.flutterwave.bean.ListResponse;
import com.flutterwave.bean.Response;
import com.flutterwave.bean.VirtualAccountRequest;
import com.flutterwave.client.Client;
import org.json.JSONObject;

import java.util.List;
import java.util.Optional;

import static com.flutterwave.bean.ChargeTypes.VIRTUAL_ACCOUNT;
import static com.flutterwave.bean.Verb.PUT;
import static com.flutterwave.client.Utility.get;
import static com.flutterwave.client.Utility.post;
import static com.flutterwave.utility.Properties.getProperty;

public class VirtualAccount {

    private String ERROR = "Error processing request, please check logs";

    public Response runTransaction(VirtualAccountRequest virtualAccountRequest){
        return Optional.of(post(getProperty("VIRTUAL_ACCOUNT_BASE"), virtualAccountRequest.toString(),
                        VIRTUAL_ACCOUNT, null))
                .map(Response::toResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }

    public Response runBulkTransaction(List<VirtualAccountRequest> virtualAccountRequests){
        return Optional.of(post(getProperty("BULK_VIRTUAL_ACCOUNT_ENDPOINT"),
                        virtualAccountRequests.toString(), VIRTUAL_ACCOUNT, null))
                .map(Response::toResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }

    public ListResponse getBulkVirtualAccounts(String batch_id){
        return Optional.of(get(getProperty("BULK_VIRTUAL_ACCOUNT_ENDPOINT")+"/"+batch_id,
                        VIRTUAL_ACCOUNT, null))
                .map(ListResponse::toListResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }

    public Response getVirtualAccount(String order_ref){
        return Optional.of(get(getProperty("VIRTUAL_ACCOUNT_BASE")+"/"+order_ref,
                        VIRTUAL_ACCOUNT, null))
                .map(Response::toResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }

    public Response updateBVN(String order_ref, String bvn){
        return Optional.ofNullable(Client.runTransaction(
                        getProperty("VIRTUAL_ACCOUNT_BASE")+"/"+order_ref,
                        new JSONObject().put("bvn", bvn).toString(),
                        PUT, VIRTUAL_ACCOUNT, null))
                .map(Response::toResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }

    public Response deleteVirtualAccount(String order_ref){
        return Optional.of(post(getProperty("VIRTUAL_ACCOUNT_BASE")+"/"+order_ref,
                        new JSONObject().put("status", "inactive").toString(),
                        VIRTUAL_ACCOUNT, null))
                .map(Response::toResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }

}
