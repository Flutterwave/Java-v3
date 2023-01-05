package com.flutterwave.services;

import com.flutterwave.bean.BeneficiaryRequest;
import com.flutterwave.bean.ListResponse;
import com.flutterwave.bean.Response;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.flutterwave.bean.ChargeTypes.BENEFICIARY;
import static com.flutterwave.client.Utility.*;
import static com.flutterwave.utility.Properties.getProperty;

/**
 * Manage Transfer Beneficiaries.
 * @author Cleopatra Douglas
 */
public class Beneficiaries {

    private String ERROR = "Error processing request, please check logs";

    /**
     * Create beneficiaries for Transfers.
     * @param beneficiaryRequest bean
     * @return Response
     */
    public Response runCreateBeneficiary(BeneficiaryRequest beneficiaryRequest){
        return Optional.of(post(getProperty("BENEFICIARY_BASE"), beneficiaryRequest.toString(),
                        BENEFICIARY, null))
                .map(Response::toResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }

    /**
     * Get all beneficiaries saves for Transfers.
     * @param page This is the page number to retrieve e.g. setting 1 retrieves the first page
     * @return ListResponse
     */
    public ListResponse runGetAllBeneficiaries(Optional<Integer> page){
        List<NameValuePair> nameValuePairs = new ArrayList<>();
        page.ifPresent(s -> nameValuePairs.add(new BasicNameValuePair("page", s.toString())));
        return Optional.of(get(getProperty("BENEFICIARY_BASE"), BENEFICIARY, nameValuePairs))
                .map(ListResponse::toListResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }

    /**
     * Get all details for a particular beneficiary.
     * @param id int This is the unique identifier for the beneficiary you intend to fetch.
     *           It is returned in the call to create a beneficiary as data.id
     * @return Response
     */
    public Response runGetBeneficiary(int id){
        return Optional.of(get(getProperty("BENEFICIARY_BASE") +"/" + id, BENEFICIARY, null))
                .map(Response::toResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }

    /**
     * Remove a beneficiary from your beneficiary list.
     * @param id int This is the unique identifier for the beneficiary you intend to fetch.
     *           It is returned in the call to create a beneficiary as data.id
     * @return Response
     */
    public Response runDeleteBeneficiary(int id){
        return Optional.of(delete(getProperty("BENEFICIARY_BASE") +"/" + id, BENEFICIARY, null))
                .map(Response::toResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }

}
