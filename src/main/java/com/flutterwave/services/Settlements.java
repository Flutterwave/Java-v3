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
 * APIs needed for managing your settlements.
 * @author Cleopatra Douglas
 */
public class Settlements {
    private String ERROR = "Error processing request, please check logs";

    /**
     * Query all settlements made to an account.
     * @param page Optional<Integer> This is the page number to retrieve e.g. setting 1 retrieves the first page.
     * @param from Optional<String> This is the specified date to start the list from. YYYY-MM-DD.
     * @param to Optional<String> The is the specified end period for the search . YYYY-MM-DD.
     * @param subaccount_id Optional<String> This is the unique id of the sub account you want to fetch. It is returned in the call to create a sub account.
     * @return ListResponse
     */
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

    /**
     * Get details on a particular settlement specified by its ID.
     * @param id int This is a unique identifier for the particular settlement you want to fetch. It is returned in the call to list all settlements as data.id.
     * @param from Optional<String> The start date range to retrieve data from. Expected format is YYYY-MM-DD.
     * @param to Optional<String> The end date range to retrieve data. Expected format is YYYY-MM-DD.
     * @return Response
     */
    public Response runGetSettlement(int id, Optional<String> from, Optional<String> to){

        List<NameValuePair> nameValuePairs = new ArrayList<>();
        to.ifPresent(s -> nameValuePairs.add(new BasicNameValuePair("to", s)));
        from.ifPresent(s -> nameValuePairs.add(new BasicNameValuePair("from", s)));

        return Optional.of(get(getProperty("SETTLEMENT_BASE")+"/"+id, SETTLEMENT, nameValuePairs))
                .map(Response::toResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }
}
