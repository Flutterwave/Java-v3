package com.flutterwave.services;

import com.flutterwave.bean.TransferRequest;
import com.flutterwave.utility.Environment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.flutterwave.utility.Properties.getProperty;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Cleopatra Douglas
 */
class TransferTest {
    TransferRequest transferRequest;

    @BeforeEach
    void setUp() {
        Environment.setSecretKey(getProperty("SECRET_KEY"));
        Environment.setPublicKey(getProperty("PUBLIC_KEY"));
        Environment.setEncryptionKey(getProperty("ENCRYPTION_KEY"));

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
        List<TransferRequest> transferRequestList = new ArrayList<>();
        transferRequestList.add(transferRequest);

        Assertions.assertEquals("success", new Transfer().runBulkTransaction(transferRequestList).getStatus());
    }

    @Test
    void retry() {
        Assertions.assertEquals("success", new Transfer().retry(0).getStatus());
    }

    @Test
    void getFee() {
        Assertions.assertEquals("success", new Transfer().getFee(new BigDecimal("200")).getStatus());
    }

    @Test
    void getTransferRate() {
        Assertions.assertEquals("success", new Transfer().getTransferRate(new BigDecimal("200"),
                "USD", "NGN").getStatus());
    }

    @Test
    void getTransfer() {
        Assertions.assertEquals("success", new Transfer().getTransfer(0).getStatus());
    }

    @Test
    void getAllTransfers() {
        Assertions.assertEquals("success", new Transfer().getAllTransfers(Optional.empty(), Optional.empty()).getStatus());
    }
}