package com.flutterwave.services;

import com.flutterwave.bean.ListResponse;
import com.flutterwave.bean.Response;
import com.flutterwave.bean.VirtualAccountRequest;
import com.flutterwave.client.Client;
import org.json.JSONObject;

import java.util.List;
import java.util.Optional;

import static com.flutterwave.bean.Verb.PUT;
import static com.flutterwave.client.Utility.get;
import static com.flutterwave.client.Utility.post;
import static com.flutterwave.utility.Properties.getProperty;

public class VirtualAccount {

    public Response runTransaction(VirtualAccountRequest virtualAccountRequest){
        return Optional.of(post(getProperty("VIRTUAL_ACCOUNT_BASE"), virtualAccountRequest.toString()))
                .map(Response::toResponse).orElseThrow();
    }

    public Response runBulkTransaction(List<VirtualAccountRequest> virtualAccountRequests){
        return Optional.of(post(getProperty("BULK_VIRTUAL_ACCOUNT_ENDPOINT"), virtualAccountRequests.toString()))
                .map(Response::toResponse).orElseThrow();
    }

    public ListResponse getBulkVirtualAccounts(String batch_id){
        return Optional.of(get(getProperty("BULK_VIRTUAL_ACCOUNT_ENDPOINT")+"/"+batch_id))
                .map(ListResponse::toListResponse).orElseThrow();
    }

    public Response getVirtualAccount(String order_ref){
        return Optional.of(get(getProperty("VIRTUAL_ACCOUNT_BASE")+"/"+order_ref))
                .map(Response::toResponse).orElseThrow();
    }

    public Response updateBVN(String order_ref, String bvn){
        return Optional.ofNullable(Client.runTransaction(
                        getProperty("VIRTUAL_ACCOUNT_BASE")+"/"+order_ref,
                        new JSONObject().put("bvn", bvn).toString(),
                        PUT))
                .map(Response::toResponse).orElseThrow();
    }

    public Response deleteVirtualAccount(String order_ref){
        return Optional.of(post(getProperty("VIRTUAL_ACCOUNT_BASE")+"/"+order_ref,
                        new JSONObject().put("status", "inactive").toString()))
                .map(Response::toResponse).orElseThrow();
    }

}
