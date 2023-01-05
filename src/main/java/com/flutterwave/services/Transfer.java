package com.flutterwave.services;

import com.flutterwave.bean.ListResponse;
import com.flutterwave.bean.Response;
import com.flutterwave.bean.TransferRequest;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.flutterwave.bean.ChargeTypes.TRANSFER;
import static com.flutterwave.client.Utility.get;
import static com.flutterwave.client.Utility.post;
import static com.flutterwave.utility.Properties.getProperty;

/**
 * Send funds to Bank acc
 * @author cleopatradouglas
 */
public class Transfer {

    private String ERROR = "Error processing request, please check logs";

    /**
     * Initate a transfer with Flutterwave.
     * @param transferRequest bean
     * @return Response
     */
    public Response runTransaction(TransferRequest transferRequest){
        return Optional.of(post(getProperty("TRANSFER_BASE"), transferRequest.toString(),
                        TRANSFER, null))
                .map(Response::toResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }

    /**
     * Create a bulk transfer, i.e. a transfer attempt for multiple transfers.
     * @param transferRequest bean
     * @return Response
     */
    public Response runBulkTransaction(List<TransferRequest> transferRequest){
        return Optional.of(post(getProperty("BULK_TRANSFER_ENDPOINT"), transferRequest.toString(),
                        TRANSFER, null))
                .map(Response::toResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }

    /**
     * Retry a previously failed transfer.
     * @param id int This is the unique identifier for the transfer you want to retry. It is returned in the call to create a transfer as data.id
     * @return Response
     */
    public Response retry(int id){
        return Optional.of(post(getProperty("TRANSFER_BASE")+id+"/retries",
                        null, TRANSFER, null))
                .map(Response::toResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }

    /**
     * Query the fee for the transfer being made.
     * @param amount BigDecimal This is the amount to be transferred.
     * @return Response
     */
    public Response getFee(BigDecimal amount){
        List<NameValuePair> nameValuePairs = new ArrayList<>();
        nameValuePairs.add(new BasicNameValuePair("amount", amount.toString()));

        return Optional.of(get(getProperty("TRANSFER_FEE_ENDPOINT"),TRANSFER, nameValuePairs))
                .map(Response::toResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }

    /**
     * Querys the transfer rate for international transfers.
     * @param amount BigDecimal This is the amount to transfer to the recipient.
     * @param destination_currency String This is the currency of the wallet you are making a transfer to.
     * @param source_currency String This is the currency of the wallet being debited for the transfer.
     * @return Response
     */
    public Response getTransferRate(BigDecimal amount, String destination_currency, String source_currency){
        List<NameValuePair> nameValuePairs = new ArrayList<>();
        nameValuePairs.add(new BasicNameValuePair("amount", amount.toString()));
        nameValuePairs.add(new BasicNameValuePair("destination_currency", destination_currency));
        nameValuePairs.add(new BasicNameValuePair("source_currency", source_currency));

        return Optional.of(get(getProperty("TRANSFER_FEE_ENDPOINT"), TRANSFER, nameValuePairs))
                .map(Response::toResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }

    /**
     * Fetch the details of a transfer.
     * @param id int This is the numeric ID of the transfer you want to fetch. It is returned in the call to create a transfer as data.id.
     * @return Response
     */
    public Response getTransfer(int id){
        return Optional.of(get(getProperty("TRANSFER_BASE")+"/"+id, TRANSFER, null))
                .map(Response::toResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }

    /**
     * Spool all their transfers.
     * @param page Optional<String> specific page e.g. setting 1 retrieves the first page.
     * @param status Optional<String> specific status e.g. fetch all successful transactions. Expected values include failed, successful.
     * @return ListResponse
     */
    public ListResponse getAllTransfers(Optional<String> page, Optional<String> status){
        List<NameValuePair> nameValuePairs = new ArrayList<>();
        page.ifPresent(s -> nameValuePairs.add(new BasicNameValuePair("page", s)));
        status.ifPresent(s -> nameValuePairs.add(new BasicNameValuePair("status", s)));

        return Optional.of(get(getProperty("TRANSFER_BASE"), TRANSFER, nameValuePairs))
                .map(ListResponse::toListResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }

}
