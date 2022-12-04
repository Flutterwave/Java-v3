package com.flutterwave.services;

import com.flutterwave.bean.BillRequest;
import com.flutterwave.bean.ListResponse;
import com.flutterwave.bean.Response;

import java.util.List;
import java.util.Optional;

import static com.flutterwave.client.Utility.get;
import static com.flutterwave.client.Utility.post;
import static com.flutterwave.utility.Properties.getProperty;

public class Bills {

    public Response runTransaction(BillRequest billRequest){
        return Optional.of(post(getProperty("BILL_BASE"), billRequest.toString()))
                .map(Response::toResponse).orElseThrow();
    }

    public Response runBulkTransaction(List<BillRequest> billRequests){
        return Optional.of(post(getProperty("BULK_BILL_ENDPOINT"), billRequests.toString()))
                .map(Response::toResponse).orElseThrow();
    }

    public Response getStatus(int id){
        return Optional.of(get(getProperty("BILL_BASE")+"/"+id))
                .map(Response::toResponse).orElseThrow();
    }

    public ListResponse getBills(String from, String to){
        //TODO: 2018-09-10- chnage to date with a format
        return Optional.of(get(getProperty("BILL_BASE")+"/?from="+from+"&to="+to))
                .map(ListResponse::toListResponse).orElseThrow();
    }

    public Response validateBillService(int item_code, String code, String customer){
        //TODO: ADD QUERY PARAMETERS
        return Optional.of(get(getProperty("VALIDATE_BILL_SERVICE_ENDPOINT")+item_code+"/validate"))
                .map(Response::toResponse).orElseThrow();
    }

    public ListResponse getCategories(int id){
        return Optional.of(get(getProperty("BILL_CATEGORY_ENDPOINT")))
                .map(ListResponse::toListResponse).orElseThrow();
    }
}
