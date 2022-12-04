package com.flutterwave.services;

import com.flutterwave.bean.ListResponse;

import java.util.Optional;

import static com.flutterwave.client.Utility.get;
import static com.flutterwave.utility.Properties.getProperty;

/**
 * @author Cleopatra Douglas
 */
public class Banks {
    public ListResponse getBanks(String country){
        return Optional.of(get(getProperty("BANKS_BASE")+country))
                .map(ListResponse::toListResponse).orElseThrow();
    }

    public ListResponse getBankBranches(int id){
        return Optional.of(get(getProperty("BANKS_BASE")+id+"/branches"))
                .map(ListResponse::toListResponse).orElseThrow();
    }
}
