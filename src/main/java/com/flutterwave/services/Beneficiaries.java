package com.flutterwave.services;

import com.flutterwave.bean.BeneficiaryRequest;
import com.flutterwave.bean.ListResponse;
import com.flutterwave.bean.Response;

import java.util.Optional;

import static com.flutterwave.bean.ChargeTypes.BENEFICIARY;
import static com.flutterwave.client.Utility.*;
import static com.flutterwave.utility.Properties.getProperty;

/**
 * @author Cleopatra Douglas
 */
public class Beneficiaries {

    private String ERROR = "Error processing request, please check logs";

    public Response runCreateBeneficiary(BeneficiaryRequest beneficiaryRequest){
        return Optional.of(post(getProperty("BENEFICIARY_BASE"), beneficiaryRequest.toString(),
                        BENEFICIARY, null))
                .map(Response::toResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }

    public ListResponse runGetAllBeneficiaries(Optional<Integer> id){
        return Optional.of(get(getProperty("BENEFICIARY_BASE"), BENEFICIARY, null))
                .map(ListResponse::toListResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }

    public Response runGetBeneficiary(int id){
        return Optional.of(get(getProperty("BENEFICIARY_BASE") +"/" + id, BENEFICIARY, null))
                .map(Response::toResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }

    public Response runDeleteBeneficiary(int id){
        return Optional.of(delete(getProperty("BENEFICIARY_BASE") +"/" + id, BENEFICIARY, null))
                .map(Response::toResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }

}
