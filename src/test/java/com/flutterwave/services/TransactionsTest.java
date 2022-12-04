package com.flutterwave.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Cleopatra Douglas
 */
class TransactionsTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void runVerifyTransaction() {
    }

    @Test
    void runGetTransactions() {
    }

    @Test
    void runGetTransactionsFees() {
    }

    @Test
    void runResendWebhook() {
    }

    @Test
    void runViewTimeline() {
    }

    @Test
    void rungetRefunds() {
        Assertions.assertEquals("success", new Transactions().new Refunds().runGet().getStatus());
    }
}