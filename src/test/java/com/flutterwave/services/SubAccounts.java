package com.flutterwave.services;

import com.flutterwave.bean.ListResponse;
import com.flutterwave.bean.Response;
import com.flutterwave.bean.SubAccountRequest;
import com.flutterwave.bean.UpdateSubAccountRequest;

import java.util.Optional;

import static com.flutterwave.client.Utility.*;
import static com.flutterwave.utility.Properties.getProperty;

/**
 * @author Cleopatra Douglas
 */
public class SubAccounts {

    public Response runCreateSubAccounts(SubAccountRequest subAccountRequest) {
        return Optional.of(post(getProperty("SUBACCOUNT_BASE"),
                        subAccountRequest.toString()))
                .map(Response::toResponse).orElseThrow();
    }

    public ListResponse runGetSubAccounts(Optional<String> account_bank, Optional<String> account_number,
                                          Optional<String> bank_name, Optional<Integer> page) {
        //TODO: query parametrs
        return Optional.of(get(getProperty("SUBACCOUNT_BASE")
//                        +(account_bank.orElse(""))
//                        +(account_number.orElse(""))
//                        +(bank_name.orElse(""))
//                        +(page.orElse(null))
                ))
                .map(ListResponse::toListResponse).orElseThrow();
    }

    public Response runGetSubAccount(int id) {
        return Optional.of(get(getProperty("SUBACCOUNT_BASE")+"/" +id))
                .map(Response::toResponse).orElseThrow();
    }

    public Response updateSubAccount(int id, UpdateSubAccountRequest updateSubAccountRequest){
        return Optional.of(put(getProperty("SUBSCRIPTION_BASE") + "/" + id, updateSubAccountRequest.toString()))
                .map(Response::toResponse).orElseThrow();
    }

    public Response runDeleteSubAccounts(int id) {
        return Optional.of(delete(getProperty("SUBACCOUNT_BASE")+ "/" + id))
                .map(Response::toResponse).orElseThrow();
    }

}
