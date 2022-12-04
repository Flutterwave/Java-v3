package com.flutterwave.services;

import com.flutterwave.bean.TransferRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Cleopatra Douglas
 */
class TransferTest {
    TransferRequest transferRequest;

    @BeforeEach
    void setUp() {

        transferRequest = new TransferRequest("https://www.flutterwave.com/ng/",
                "akhlm-pstmnpyt-rfxx007_PMCKDU_1",
                "NGN",
                "044",
                "0690000040",
                "Akhlm Pstmn Trnsfr xx007",
                new BigDecimal("10"),
                "NGN");
    }

    @Test
    void runTransaction() {
        Assertions.assertEquals("success", new Transfer().runTransaction(transferRequest).getStatus());
    }

    @Test
    void runBulkTransaction() {
    }

    @Test
    void retry() {
    }

    @Test
    void getFee() {
        Assertions.assertEquals("success", new Transfer().getFee(new BigDecimal("200")).getStatus());
    }

    @Test
    void getTransfer() {
    }

    @Test
    void getAllTransfers() {
    }
}