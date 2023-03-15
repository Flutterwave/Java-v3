package com.flutterwave.services;

import com.flutterwave.bean.TokenizedChargeRequest;
import com.flutterwave.bean.UpdateTokenRequest;
import com.flutterwave.utility.Environment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.flutterwave.utility.Properties.getProperty;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Cleopatra Douglas
 */
class TokenizedChargeTest {

    TokenizedChargeRequest tokenizedChargeRequest;
    UpdateTokenRequest updateTokenRequest;

    @BeforeEach
    void setUp() {
        Environment.setSecretKey(getProperty("SEC_KEY"));
        Environment.setPublicKey(getProperty("PUB_KEY"));
        Environment.setEncryptionKey(getProperty("ENCR_KEY"));

        tokenizedChargeRequest = new TokenizedChargeRequest("flw-t1nf-cacf9661f2a07b761a166d7c894fa801-m03k",
                "NGN",
                "NG",
                new BigDecimal("20"),
                "stefan.wexler@hotmail.eu",
                "Yolande Aglaé Colbert",
                "Colbert",
                "0.0.0.0",
                "Sample tokenized charge",
                "javasdk-test");


        updateTokenRequest = new UpdateTokenRequest("developers@flutterwavego.com",
                "Flutterwave Developers",
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
        Assertions.assertEquals("success", new TokenizedCharge().runUpdateToken("flw-t1nf-cacf9661f2a07b761a166d7c894fa801-m03k", updateTokenRequest).getStatus());
    }
}