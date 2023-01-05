package com.flutterwave.services;

import com.flutterwave.bean.*;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.flutterwave.bean.ChargeTypes.SUBACCOUNT;
import static com.flutterwave.bean.SubAccountTypes.COLLECTION;
import static com.flutterwave.client.Utility.*;
import static com.flutterwave.utility.Properties.getProperty;

/**
 * Manage Collection Subaccounts.
 * @author Cleopatra Douglas
 */
public class SubAccounts {

    private String ERROR = "Error processing request, please check logs";

    /**
     * Create a subaccount on Flutterwave.
     * @param collectionsSubAccountRequest bean
     * @param payoutSubAccountRequest bean
     * @param type COLLECTION or PAYOUT
     * @return Response
     */
    public Response runCreateSubAccounts(CollectionsSubAccountRequest collectionsSubAccountRequest,
                                         Optional<PayoutSubAccountRequest> payoutSubAccountRequest,
                                         SubAccountTypes type) {

        return type.equals(COLLECTION) ? Optional.of(post(getProperty("COLLECTIONS_SUBACCOUNT_BASE"),
                        collectionsSubAccountRequest.toString(), SUBACCOUNT, null))
                .map(Response::toResponse).orElseThrow(() -> new RuntimeException(ERROR))
                : Optional.of(post(getProperty("PAYOUT_SUBACCOUNT_BASE"),
                        payoutSubAccountRequest.toString(), SUBACCOUNT, null))
                .map(Response::toResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }

    /**
     * List all subaccounts on Flutterwave.
     * @param account_bank Optional This is the sub-accounts bank ISO code
     * @param account_number Optional This is the account number associated with the subaccount you want to fetch
     * @param bank_name Optional This is the name of the bank associated with the ISO code provided in account_bankfield
     * @param page Optional This is the page number to retrieve e.g. setting 1 retrieves the first page
     * @param type COLLECTION or PAYOUT
     * @return ListResponse
     */
    public ListResponse runGetSubAccounts(Optional<String> account_bank, Optional<String> account_number,
                                          Optional<String> bank_name, Optional<Integer> page, SubAccountTypes type) {

        List<NameValuePair> nameValuePairs = new ArrayList<>();
        account_bank.ifPresent(s -> nameValuePairs.add(new BasicNameValuePair("account_bank", s)));
        account_number.ifPresent(s -> nameValuePairs.add(new BasicNameValuePair("account_number", s)));
        bank_name.ifPresent(s -> nameValuePairs.add(new BasicNameValuePair("bank_name", s)));
        page.ifPresent(s -> nameValuePairs.add(new BasicNameValuePair("page", s.toString())));

        return type.equals(COLLECTION) ? Optional.of(
                        get(getProperty("COLLECTIONS_SUBACCOUNT_BASE"),
                                SUBACCOUNT,
                                nameValuePairs
                        )).map(ListResponse::toListResponse)
                .orElseThrow(() -> new RuntimeException(ERROR))
                : Optional.of(get(getProperty("PAYOUT_SUBACCOUNT_BASE"),
                        SUBACCOUNT,
                        null)).map(ListResponse::toListResponse)
                .orElseThrow(() -> new RuntimeException(ERROR));

    }

    /**
     * Fetch a subaccount on Flutterwave.
     * @param id INT This is the unique id of the sub account you want to fetch. It is returned in the call to create a sub account as data.id
     * @param account_reference Optional The unique reference for the payout
     * @param include_limit Optional Pass this parameter to ensure the limit for the subaccount are returned in the response
     * @param type COLLECTION or PAYOUT
     * @return Response
     */
    public Response runGetSubAccount(int id, Optional<String> account_reference,
                                     Optional<String> include_limit, SubAccountTypes type) {

        List<NameValuePair> nameValuePairs = new ArrayList<>();
        include_limit.ifPresent(s -> nameValuePairs.add(new BasicNameValuePair("include_limit", s)));

        return type.equals(COLLECTION) ?
                Optional.of(get(getProperty("COLLECTIONS_SUBACCOUNT_BASE") + "/" + id, SUBACCOUNT,
                                null))
                        .map(Response::toResponse).orElseThrow(() -> new RuntimeException(ERROR))
                : Optional.of(get(getProperty("PAYOUT_SUBACCOUNT_BASE") + "/" + account_reference, SUBACCOUNT,
                        nameValuePairs))
                .map(Response::toResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }

    /**
     * Update a collection subaccount on Flutterwave.
     * @param id int This is the unique id of the subaccount you want to update. It is returned in the call to create a subaccount as data.id
     * @param updateCollectionSubAccountRequest bean
     * @param updatePayoutSubAccountRequest bean
     * @param account_reference Optional The unique reference for the payout
     * @param type COLLECTION or PAYOUT
     * @return
     */
    public Response updateSubAccount(int id, UpdateCollectionSubAccountRequest updateCollectionSubAccountRequest,
                                     Optional<UpdatePayoutSubAccountRequest> updatePayoutSubAccountRequest,
                                     Optional<String> account_reference, SubAccountTypes type) {
        return type.equals(COLLECTION) ?
                Optional.of(put(getProperty("SUBSCRIPTION_BASE") + "/" + id,
                                updateCollectionSubAccountRequest.toString(), SUBACCOUNT, null))
                        .map(Response::toResponse).orElseThrow(() -> new RuntimeException(ERROR)) :
                Optional.of(put(getProperty("PAYOUT_SUBACCOUNT_BASE") + "/" + account_reference,
                                updatePayoutSubAccountRequest.toString(), SUBACCOUNT, null))
                        .map(Response::toResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }

    /**
     * Delete a collection subaccount on Flutterwave.
     * @param id int This is the unique id of the sub account you want to fetch. It is returned in the call to create a sub account as data.id
     * @return Response
     */
    public Response runDeleteCollectionSubAccounts(int id) {
        return Optional.of(delete(getProperty("COLLECTIONS_SUBACCOUNT_BASE") + "/" + id,
                        SUBACCOUNT, null))
                .map(Response::toResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }

    /**
     * Fetch a transaction on a payout/transfer subaccount on Flutterwave.
     * @param account_reference String The unique reference for the payout
     * @param from String start date
     * @param to String end date
     * @param currency String currency of the subaccount. The possible values are USD, EUR, GBP and NGN
     * @return Response
     */
    public Response runGetPayoutSubAccountTransactions(String account_reference, String from,
                                                       String to, String currency) {

        List<NameValuePair> nameValuePairs = new ArrayList<>();
        nameValuePairs.add(new BasicNameValuePair("from", from));
        nameValuePairs.add(new BasicNameValuePair("to", to));
        nameValuePairs.add(new BasicNameValuePair("currency", currency));

        return Optional.of(get(getProperty("PAYOUT_SUBACCOUNT_BASE") + "/" + account_reference,
                        SUBACCOUNT, nameValuePairs))
                .map(Response::toResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }

    /**
     * Fetch the available balance on a payout/transfer subaccount on Flutterwave.
     * @param account_reference String The unique reference for the payout
     * @param currency String currency of the subaccount. The possible values are USD, EUR, GBP and NGN
     * @return Response
     */
    public Response runGetPayoutSubAccountBalance(String account_reference, String currency) {
        List<NameValuePair> nameValuePairs = new ArrayList<>();
        nameValuePairs.add(new BasicNameValuePair("currency", currency));

        return Optional.of(get(getProperty("PAYOUT_SUBACCOUNT_BASE") + "/" + account_reference + "/balances",
                        SUBACCOUNT, nameValuePairs))
                .map(Response::toResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }

    /**
     * Fetch a static virtual account on a payout/transfer subaccount on Flutterwave
     * @param account_reference String The unique reference for the payout
     * @param currency String currency of the subaccount. The possible values are USD, EUR, GBP and NGN
     * @return Response
     */
    public Response runGetPayoutSubAccountStaticVirtualAccount(String account_reference, String currency) {
        List<NameValuePair> nameValuePairs = new ArrayList<>();
        nameValuePairs.add(new BasicNameValuePair("currency", currency));

        return Optional.of(get(getProperty("PAYOUT_SUBACCOUNT_BASE") + "/" + account_reference + "/static-account",
                        SUBACCOUNT, null))
                .map(Response::toResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }

}
