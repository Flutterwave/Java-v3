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

/**
 * APIs endpoints needed to purchase bill payments.
 * Supported Bill Payments include - Airtime, Data purchase, Electricity bills, Cable bills and Government remittance.
 * @author cleopatradouglas
 */
public class Bills {
    private String ERROR = "Error processing request, please check logs";

    /**
     * Initiate the bill payment. You can create Airtime, Data, Cable, Power,
     * Toll and other bill payment you need. Kindly note that your balance should be funded as your wallet would be debited for successful API calls.
     * @param billRequest bean
     * @return Response
     */
    public Response runTransaction(BillRequest billRequest){
        return Optional.of(post(getProperty("BILL_BASE"), billRequest.toString(), BILLS, null))
                .map(Response::toResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }

    /**
     * Create bulk bills payment
     * @param billRequests bean
     * @return Response
     */
    public Response runBulkTransaction(List<BillRequest> billRequests){
        return Optional.of(post(getProperty("BULK_BILL_ENDPOINT"), billRequests.toString(), BILLS, null))
                .map(Response::toResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }

    /**
     * Get the status of a bill purchase
     * @param reference String This is the tx_ref of the bill transaction
     * @return Response
     */
    public Response getStatus(String reference){
        return Optional.of(get(getProperty("BILL_BASE")+"/"+reference, BILLS, null))
                .map(Response::toResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }

    /**
     * Retrieve a history of all purchased bill services including commission earned
     * @param from String This is the start date it can be in any of this formats: YYYY-MM-DDTHH:MM:SSZ or YYYY-MM-DD
     * @param to String This is the end date, it can be in any of this formats: YYYY-MM-DDTHH:MM:SSZ or YYYY-MM-DD
     * @return ListResponse
     */
    public ListResponse getBills(String from, String to){
        //TODO: 2018-09-10- chnage to date with a format
        return Optional.of(get(getProperty("BILL_BASE")+"/?from="+from+"&to="+to, BILLS, null))
                .map(ListResponse::toListResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }

    /**
     * Validate services like DSTV smartcard no, Meter number etc.
     * @param item_code String This code is returned from the /getBillCategory endpoint as data[i].item_code, where i is the index in the data array contained in the response object.
     * @param code String This is the biller code. It is returned in the /getBillCategory endpoint as data[i].biller_code, where i is the index in the data array contained in the response object.
     * @param customer String This is the customer identifier for the bill payment e.g. for airtime, the identifier would be the customer's mobile number.
     * @return Response
     */
    public Response validateBillService(String item_code, String code, String customer){
        List<NameValuePair> nameValuePairs = new ArrayList<>();
        nameValuePairs.add(new BasicNameValuePair("code", code));
        nameValuePairs.add(new BasicNameValuePair("customer", customer));

        return Optional.of(get(getProperty("VALIDATE_BILL_SERVICE_ENDPOINT")+item_code+"/validate", BILLS, nameValuePairs))
                .map(Response::toResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }

    /**
     * Retrieve the information for each Biller.
     * These information are important as they are required for the bill payment attempt. You can filter your query by biller type and biller_code.
     * @param airtime Optional<Integer> This parameter allows you filter the response object for airtime billers only (MTN, Vodafone, Airtel, 9mobile).
     *                You should set this to 1 if you would like to filter only airtime billers. Expected values are 0 and 1.
     * @param data_bundle Optional<Integer> This parameter allows you filter the response object for data billers only (MTN, Vodafone, Airtel, 9mobile).
     *                    You should set this to 1 if you would like to filter only data billers. Expected values are 0 and 1.
     * @param power Optional<Integer> This parameter allows you filter the response object for power billers only (EKEDC, IKEDC, KDLC).
     *              You should set this to 1 if you would like to filter only power billers. Expected values are 0 and 1.
     * @param internet Optional<Integer> This parameter allows you filter the response object for internet billers only (SWIFT, Smile, ipNX).
     *                 You should set this to 1 if you would like to filter only internet billers. Expected values are 0 and 1.
     * @param toll Optional<Integer> This parameter allows you filter the response object for toll billers only.
     *             You should set this to 1 if you would like to filter only toll billers. Expected values are 0 and 1.
     * @param cable Optional<Integer> This parameter allows you filter the response object for cable billers only (DSTV, Startimes, GOTV).
     *              You should set this to 1 if you would like to filter only cable billers. Expected values are 0 and 1.
     * @param biller_code Optional<String> This parameter allows you filter the response object for a specific Biller using the biller_code.
     * @return ListResponse
     */
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
