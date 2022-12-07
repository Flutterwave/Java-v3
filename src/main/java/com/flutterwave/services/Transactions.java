package com.flutterwave.services;

import com.flutterwave.bean.ListResponse;
import com.flutterwave.bean.Response;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.flutterwave.bean.ChargeTypes.*;
import static com.flutterwave.client.Utility.get;
import static com.flutterwave.client.Utility.post;
import static com.flutterwave.utility.Properties.getProperty;

/**
 * @author Cleopatra Douglas
 */
public class Transactions {
    private String ERROR = "Error processing request, please check logs";

    public Response runVerifyTransaction(int id) {
        return Optional.of(get(getProperty("VERIFY_TRANSACTION_ENDPOINT") + id + "/verify",
                        VERIFY_TRANSACTION, null))
                .map(Response::toResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }

    public ListResponse runGetTransactions() {
        return Optional.of(get(getProperty("VERIFY_TRANSACTION_ENDPOINT"),
                        GET_TRANSACTION, null))
                .map(ListResponse::toListResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }

    public Response runGetTransactionsFees(BigDecimal amount, String currency) {
        List<NameValuePair> nameValuePairs = new ArrayList<>();
        nameValuePairs.add(new BasicNameValuePair("amount", amount.toString()));
        nameValuePairs.add(new BasicNameValuePair("currency", currency));

        return Optional.of(get(getProperty("VERIFY_TRANSACTION_ENDPOINT"), GET_TRANSACTION, nameValuePairs))
                .map(Response::toResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }

    public Response runResendWebhook(int id, Optional<Integer> wait) {
        List<NameValuePair> nameValuePairs = new ArrayList<>();
        wait.ifPresent(s -> nameValuePairs.add(new BasicNameValuePair("wait", wait.toString())));

        return Optional.of(post(getProperty("VERIFY_TRANSACTION_ENDPOINT") + id + "/resend-hook",
                        null,
                        GET_TRANSACTION,
                        nameValuePairs))
                .map(Response::toResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }

    public ListResponse runViewTimeline(int id) {
        return Optional.of(get(getProperty("VERIFY_TRANSACTION_ENDPOINT") + id + "/events",
                        GET_TRANSACTION, null))
                .map(ListResponse::toListResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }

    public class Refunds {
        public ListResponse runGet() {
            return Optional.of(get(getProperty("REFUND_ENDPOINT"),
                            REFUND, null))
                    .map(ListResponse::toListResponse).orElseThrow(() -> new RuntimeException(ERROR));
        }

        public Response runRefund(int id, Optional<BigDecimal> amount) {
            return Optional.of(post(getProperty("VERIFY_TRANSACTION_ENDPOINT") + id + "/refund",
                            new JSONObject().put("amount", amount).toString(), REFUND, null))
                    .map(Response::toResponse).orElseThrow(() -> new RuntimeException(ERROR));
        }

        public Response runGetDetails(int id) {
            return Optional.of(get(getProperty("VERIFY_TRANSACTION_ENDPOINT") + id + "/refund",
                            REFUND, null))
                    .map(Response::toResponse).orElseThrow(() -> new RuntimeException(ERROR));
        }


    }
}
