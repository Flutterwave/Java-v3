package com.flutterwave.services;

import com.flutterwave.bean.*;

import java.util.Optional;

import static com.flutterwave.bean.SubAccountTypes.COLLECTION;
import static com.flutterwave.client.Utility.*;
import static com.flutterwave.utility.Properties.getProperty;

/**
 * @author Cleopatra Douglas
 */
public class SubAccounts {

    public Response runCreateSubAccounts(CollectionsSubAccountRequest collectionsSubAccountRequest,
                                         Optional<PayoutSubAccountRequest> payoutSubAccountRequest,
                                         SubAccountTypes type) {

        return type.equals(COLLECTION) ? Optional.of(post(getProperty("COLLECTIONS_SUBACCOUNT_BASE"),
                        collectionsSubAccountRequest.toString()))
                .map(Response::toResponse).orElseThrow() :  Optional.of(post(getProperty("PAYOUT_SUBACCOUNT_BASE"),
                        payoutSubAccountRequest.toString()))
                .map(Response::toResponse).orElseThrow();
    }

    public ListResponse runGetSubAccounts(Optional<String> account_bank, Optional<String> account_number,
                                          Optional<String> bank_name, Optional<Integer> page, SubAccountTypes type) {
        //TODO: query parametrs
        return type.equals(COLLECTION) ? Optional.of(get(getProperty("COLLECTIONS_SUBACCOUNT_BASE")
//                        +(account_bank.orElse(""))
//                        +(account_number.orElse(""))
//                        +(bank_name.orElse(""))
//                        +(page.orElse(null))
                )).map(ListResponse::toListResponse).orElseThrow()
                : Optional.of(get(getProperty("PAYOUT_SUBACCOUNT_BASE")
        )).map(ListResponse::toListResponse).orElseThrow();

    }

    public Response runGetSubAccount(int id, Optional<String> account_reference,
                                     Optional<String> include_limit, SubAccountTypes type) {
        return type.equals(COLLECTION) ?
                Optional.of(get(getProperty("COLLECTIONS_SUBACCOUNT_BASE")+"/" +id))
                .map(Response::toResponse).orElseThrow()
                : Optional.of(get(getProperty("PAYOUT_SUBACCOUNT_BASE")+"/" +account_reference))
                //TODO: add query parameter include_limit
                .map(Response::toResponse).orElseThrow();
    }

    public Response updateSubAccount(int id, UpdateCollectionSubAccountRequest updateCollectionSubAccountRequest,
                                     Optional<UpdatePayoutSubAccountRequest> updatePayoutSubAccountRequest,
                                     Optional<String> account_reference, SubAccountTypes type){
        return type.equals(COLLECTION) ?
                Optional.of(put(getProperty("SUBSCRIPTION_BASE") + "/" + id,
                        updateCollectionSubAccountRequest.toString()))
                .map(Response::toResponse).orElseThrow() :
                Optional.of(put(getProperty("PAYOUT_SUBACCOUNT_BASE") + "/" + account_reference,
                                updatePayoutSubAccountRequest.toString()))
                        .map(Response::toResponse).orElseThrow();
    }

    public Response runDeleteCollectionSubAccounts(int id) {
        return Optional.of(delete(getProperty("COLLECTIONS_SUBACCOUNT_BASE")+ "/" + id))
                .map(Response::toResponse).orElseThrow();
    }

    public Response runGetPayoutSubAccountTransactions(String account_reference, String from,
                                                       String to, String currency) {
        ///TODO: query parametrs
        return Optional.of(get(getProperty("PAYOUT_SUBACCOUNT_BASE")+ "/" + account_reference))
                .map(Response::toResponse).orElseThrow();
    }

    public Response runGetPayoutSubAccountBalance(String account_reference, String currency) {
        //TODO: query parametrs
        return Optional.of(get(getProperty("PAYOUT_SUBACCOUNT_BASE")+ "/" + account_reference +"/balances"))
                .map(Response::toResponse).orElseThrow();
    }

    public Response runGetPayoutSubAccountStaticVirtualAccount(String account_reference, String currency) {
        //TODO: query parametrs
        return Optional.of(get(getProperty("PAYOUT_SUBACCOUNT_BASE")+ "/" + account_reference +"/static-account"))
                .map(Response::toResponse).orElseThrow();
    }

}
