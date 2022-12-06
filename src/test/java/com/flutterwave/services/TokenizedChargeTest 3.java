package com.flutterwave.services;

import com.flutterwave.bean.TokenizedChargeRequest;
import com.flutterwave.bean.UpdateTokenRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Cleopatra Douglas
 */
class TokenizedChargeTest {

    TokenizedChargeRequest tokenizedChargeRequest;
    UpdateTokenRequest updateTokenRequest;

    @BeforeEach
    void setUp() {
        tokenizedChargeRequest = new TokenizedChargeRequest("flw-t1nf-f9b3bf384cd30d6fca42b6df9d27bd2f-m03k",
                "NGN",
                "NG",
                new BigDecimal("2000"),
                "developers@flutterwavego.com",
                "Flutterwave",
                "Developers",
                "123.876.0997.9",
                "Sample tokenized charge",
                "tokenized-c-001");


        updateTokenRequest = new UpdateTokenRequest("user@example.com",
                "Kendrick Graham",
                "0813XXXXXXX");
    }

    @Test
    void runTransaction() {
        Assertions.assertEquals("success", new TokenizedCharge().runTransaction(tokenizedChargeRequest).getStatus());
    }

    @Test
    void runBulkTransaction() {
        List<TokenizedChargeRequest> tokenizedChargeRequestList= new ArrayList<>();
        tokenizedChargeRequestList.add(tokenizedChargeRequest);

        Assertions.assertEquals("success", new TokenizedCharge().runBulkTransaction(tokenizedChargeRequestList).getStatus());
    }

//    @Test
    void runGetBulkTransaction(int id) {
        Assertions.assertEquals("success", new TokenizedCharge().runGetBulkTransaction(id).getStatus());
    }

//    @Test
    void runGetBulkTransactionStatus(int id) {
        Assertions.assertEquals("success", new TokenizedCharge().runGetBulkTransactionStatus(id).getStatus());
    }

    @Test
    void runUpdateToken() {
        Assertions.assertEquals("success", new TokenizedCharge().runUpdateToken("", updateTokenRequest).getStatus());
    }
}