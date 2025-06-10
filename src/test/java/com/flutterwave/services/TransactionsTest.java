package com.flutterwave.services;

import com.flutterwave.utility.Environment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Optional;

import static com.flutterwave.utility.Properties.getProperty;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Cleopatra Douglas
 */
class TransactionsTest {

    @BeforeEach
    void setUp() {
        Environment.setSecretKey(getProperty("SEC_KEY"));
        Environment.setPublicKey(getProperty("PUB_KEY"));
        Environment.setEncryptionKey(getProperty("ENCR_KEY"));
    }

    @Test
    void runVerifyTransaction() {
        Assertions.assertEquals("success", new Transactions().runVerifyTransaction(0).getStatus());
    }

    @Test
    void runGetTransactions() {
        Assertions.assertEquals("success", new Transactions().runGetTransactions(Optional.empty(),
                Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(),
                Optional.empty(), Optional.empty()).getStatus());
    }

    @Test
    void runGetTransactionsFees() {
        Assertions.assertEquals("success", new Transactions().runGetTransactionsFees(new BigDecimal("10"),
                "NGN").getStatus());
    }

    @Test
    void runResendWebhook() {
        Assertions.assertEquals("success", new Transactions().runResendWebhook(0,
                Optional.empty()).getStatus());
    }

    @Test
    void runViewTimeline() {
        Assertions.assertEquals("success", new Transactions().runViewTimeline(0).getStatus());
    }

    @Test
    void rungetRefunds() {
        Assertions.assertEquals("success", new Transactions().new Refunds().runGet(
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty()
        ).getStatus());
    }

    @Test
    void runRefund() {
        Assertions.assertEquals("success", new Transactions().new Refunds().runRefund(0,
                Optional.empty()).getStatus());
    }

    @Test
    void runGetDetails() {
        Assertions.assertEquals("success", new Transactions().new Refunds().runGetDetails(0).getStatus());
    }
}