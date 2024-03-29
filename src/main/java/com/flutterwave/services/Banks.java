package com.flutterwave.services;

import com.flutterwave.bean.ListResponse;

import java.util.Optional;

import static com.flutterwave.bean.ChargeTypes.GET_BANKS;
import static com.flutterwave.client.Utility.get;
import static com.flutterwave.utility.Properties.getProperty;

/**
 * @author Cleopatra Douglas
 */
public class Banks {
    /**
     * Retrieves bank list
     * @param country to retrieve
     * @return ListResponse
     */
    public ListResponse getBanks(String country){
        return Optional.of(get(getProperty("BANKS_BASE")+country, GET_BANKS, null))
                .map(ListResponse::toListResponse).orElseThrow();
    }

    /**
     * Retrieves bank branches
     * @param id for bank
     * @return ListResponse
     */
    public ListResponse getBankBranches(int id){
        return Optional.of(get(getProperty("BANKS_BASE")+id+"/branches", GET_BANKS, null))
                .map(ListResponse::toListResponse).orElseThrow();
    }
}
