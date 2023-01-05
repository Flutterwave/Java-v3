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

/**
 * @author Cleopatra Douglas
 */
public class VirtualAccount {

    private String ERROR = "Error processing request, please check logs";

    /**
     * Create a virtual account number
     * @param virtualAccountRequest bean
     * @return Response
     */
    public Response runTransaction(VirtualAccountRequest virtualAccountRequest){
        return Optional.of(post(getProperty("VIRTUAL_ACCOUNT_BASE"), virtualAccountRequest.toString(),
                        VIRTUAL_ACCOUNT, null))
                .map(Response::toResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }

    /**
     * Create bulk virtual account numbers
     * @param virtualAccountRequests bean
     * @return Response
     */
    public Response runBulkTransaction(List<VirtualAccountRequest> virtualAccountRequests){
        return Optional.of(post(getProperty("BULK_VIRTUAL_ACCOUNT_ENDPOINT"),
                        virtualAccountRequests.toString(), VIRTUAL_ACCOUNT, null))
                .map(Response::toResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }

    /**
     * Fetch bulk virtual account numbers using batch id
     * @param batch_id This is the batch ID returned in the bulk virtual account numbers creation
     * @return ListResponse
     */
    public ListResponse getBulkVirtualAccounts(String batch_id){
        return Optional.of(get(getProperty("BULK_VIRTUAL_ACCOUNT_ENDPOINT")+"/"+batch_id,
                        VIRTUAL_ACCOUNT, null))
                .map(ListResponse::toListResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }

    /**
     * Fetch a virtual account number using order reference
     * @param order_ref String This is the order reference returned in the virtual account number creation
     * @return Response
     */
    public Response getVirtualAccount(String order_ref){
        return Optional.of(get(getProperty("VIRTUAL_ACCOUNT_BASE")+"/"+order_ref,
                        VIRTUAL_ACCOUNT, null))
                .map(Response::toResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }

    /**
     * Update the BVN of previously created virtual accounts.
     * @param order_ref This is the order reference returned in the virtual account number creation
     * @param bvn This is only required for static accounts It should be BVN number tied to the user the account number is being generated for
     * @return Response
     */
    public Response updateBVN(String order_ref, String bvn){
        return Optional.ofNullable(Client.runTransaction(
                        getProperty("VIRTUAL_ACCOUNT_BASE")+"/"+order_ref,
                        new JSONObject().put("bvn", bvn).toString(),
                        PUT, VIRTUAL_ACCOUNT, null))
                .map(Response::toResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }

    /**
     * Delete a Virtual account
     * @param order_ref String This is the order reference returned in the virtual account number creation
     * @return Response
     */
    public Response deleteVirtualAccount(String order_ref){
        return Optional.of(post(getProperty("VIRTUAL_ACCOUNT_BASE")+"/"+order_ref,
                        new JSONObject().put("status", "inactive").toString(),
                        VIRTUAL_ACCOUNT, null))
                .map(Response::toResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }

}
