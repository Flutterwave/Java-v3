package com.flutterwave.services;

import com.flutterwave.bean.BillRequest;
import com.flutterwave.bean.ListResponse;
import com.flutterwave.bean.Response;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.flutterwave.bean.ChargeTypes.BILLS;
import static com.flutterwave.client.Utility.get;
import static com.flutterwave.client.Utility.post;
import static com.flutterwave.utility.Properties.getProperty;

public class Bills {
    private String ERROR = "Error processing request, please check logs";

    public Response runTransaction(BillRequest billRequest){
        return Optional.of(post(getProperty("BILL_BASE"), billRequest.toString(), BILLS, null))
                .map(Response::toResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }

    public Response runBulkTransaction(List<BillRequest> billRequests){
        return Optional.of(post(getProperty("BULK_BILL_ENDPOINT"), billRequests.toString(), BILLS, null))
                .map(Response::toResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }

    public Response getStatus(int id){
        return Optional.of(get(getProperty("BILL_BASE")+"/"+id, BILLS, null))
                .map(Response::toResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }

    public ListResponse getBills(String from, String to){
        //TODO: 2018-09-10- chnage to date with a format
        return Optional.of(get(getProperty("BILL_BASE")+"/?from="+from+"&to="+to, BILLS, null))
                .map(ListResponse::toListResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }

    public Response validateBillService(String item_code, String code, String customer){
        List<NameValuePair> nameValuePairs = new ArrayList<>();
        nameValuePairs.add(new BasicNameValuePair("code", code));
        nameValuePairs.add(new BasicNameValuePair("customer", customer));

        return Optional.of(get(getProperty("VALIDATE_BILL_SERVICE_ENDPOINT")+item_code+"/validate", BILLS, nameValuePairs))
                .map(Response::toResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }

    public ListResponse getCategories(Optional<Integer> airtime, Optional<Integer> data_bundle,
                                      Optional<Integer> power, Optional<Integer> internet,
                                      Optional<Integer> toll, Optional<Integer> cable, Optional<String> biller_code){
        List<NameValuePair> nameValuePairs = new ArrayList<>();
        airtime.ifPresent(s -> nameValuePairs.add(new BasicNameValuePair("airtime", s.toString())));
        data_bundle.ifPresent(s -> nameValuePairs.add(new BasicNameValuePair("data_bundle", s.toString())));
        power.ifPresent(s -> nameValuePairs.add(new BasicNameValuePair("power", s.toString())));
        internet.ifPresent(s -> nameValuePairs.add(new BasicNameValuePair("internet", s.toString())));
        toll.ifPresent(s -> nameValuePairs.add(new BasicNameValuePair("toll", s.toString())));
        cable.ifPresent(s -> nameValuePairs.add(new BasicNameValuePair("cable", s.toString())));
        biller_code.ifPresent(s -> nameValuePairs.add(new BasicNameValuePair("biller_code", s)));

        return Optional.of(get(getProperty("BILL_CATEGORY_ENDPOINT"), BILLS, nameValuePairs))
                .map(ListResponse::toListResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }
}
