package com.flutterwave.services;

import com.flutterwave.bean.ListResponse;
import com.flutterwave.bean.Response;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.flutterwave.bean.ChargeTypes.SETTLEMENT;
import static com.flutterwave.client.Utility.get;
import static com.flutterwave.utility.Properties.getProperty;

/**
 * @author Cleopatra Douglas
 */
public class Settlements {
    private String ERROR = "Error processing request, please check logs";

    public ListResponse runGetAllSettlements(Optional<Integer> page, Optional<String> from, Optional<String> to,
                                             Optional<String> subaccount_id){
        List<NameValuePair> nameValuePairs = new ArrayList<>();
        subaccount_id.ifPresent(s -> nameValuePairs.add(new BasicNameValuePair("subaccount_id", s)));
        to.ifPresent(s -> nameValuePairs.add(new BasicNameValuePair("to", s)));
        from.ifPresent(s -> nameValuePairs.add(new BasicNameValuePair("from", s)));
        page.ifPresent(s -> nameValuePairs.add(new BasicNameValuePair("page", s.toString())));


        return Optional.of(get(getProperty("SETTLEMENT_BASE"), SETTLEMENT, nameValuePairs))
                .map(ListResponse::toListResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }

    public Response runGetSettlement(int id, Optional<String> from, Optional<String> to){

        List<NameValuePair> nameValuePairs = new ArrayList<>();
        to.ifPresent(s -> nameValuePairs.add(new BasicNameValuePair("to", s)));
        from.ifPresent(s -> nameValuePairs.add(new BasicNameValuePair("from", s)));

        return Optional.of(get(getProperty("SETTLEMENT_BASE")+"/"+id, SETTLEMENT, nameValuePairs))
                .map(Response::toResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }
}
