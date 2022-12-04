package com.flutterwave.services;

import com.flutterwave.bean.ListResponse;
import com.flutterwave.bean.Response;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.util.Optional;

import static com.flutterwave.client.Utility.get;
import static com.flutterwave.client.Utility.post;
import static com.flutterwave.utility.Properties.getProperty;

/**
 * @author Cleopatra Douglas
 */
public class Transactions {

    public Response runVerifyTransaction(int id) {
        return Optional.of(get(getProperty("VERIFY_TRANSACTION_ENDPOINT") + id + "/verify"))
                .map(Response::toResponse).orElseThrow();
    }

    public ListResponse runGetTransactions() {
        return Optional.of(get(getProperty("VERIFY_TRANSACTION_ENDPOINT")))
                .map(ListResponse::toListResponse).orElseThrow();
    }

    public Response runGetTransactionsFees(BigDecimal amount, String currency) {
        //TODO: allow query params on client
        return Optional.of(get(getProperty("VERIFY_TRANSACTION_ENDPOINT")))
                .map(Response::toResponse).orElseThrow();
    }

    public Response runResendWebhook(int id, Optional<Integer> wait) {
        return Optional.of(post(getProperty("VERIFY_TRANSACTION_ENDPOINT") + id + "/resend-hook",
                        null))
                .map(Response::toResponse).orElseThrow();
    }

    public ListResponse runViewTimeline(int id) {
        return Optional.of(get(getProperty("VERIFY_TRANSACTION_ENDPOINT") + id + "/events"))
                .map(ListResponse::toListResponse).orElseThrow();
    }

    public class Refunds {
        public ListResponse runGet() {
            return Optional.of(get(getProperty("REFUND_ENDPOINT")))
                    .map(ListResponse::toListResponse).orElseThrow();
        }

        public Response runRefund(int id, Optional<BigDecimal> amount) {
            return Optional.of(post(getProperty("VERIFY_TRANSACTION_ENDPOINT") + id + "/refund",
                            new JSONObject().put("amount", amount).toString()))
                    .map(Response::toResponse).orElseThrow();
        }

        public Response runGetDetails(int id) {
            return Optional.of(get(getProperty("VERIFY_TRANSACTION_ENDPOINT") + id + "/refund"))
                    .map(Response::toResponse).orElseThrow();
        }


    }
}
