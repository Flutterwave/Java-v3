package com.flutterwave.services;

import com.flutterwave.bean.BillRequest;
import com.flutterwave.bean.Recurrence;
import com.flutterwave.bean.Response;
import com.flutterwave.utility.Environment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.flutterwave.bean.Recurrence.ONCE;
import static com.flutterwave.utility.Properties.getProperty;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Cleopatra Douglas
 */
class BillsTest {
    BillRequest billRequest;

    @BeforeEach
    void setUp() {
        Environment.setSecretKey(getProperty("SEC_KEY"));
        Environment.setPublicKey(getProperty("PUB_KEY"));
        Environment.setEncryptionKey(getProperty("ENCR_KEY"));

        billRequest = new BillRequest("NG",
                "+23490803840303",
                new BigDecimal("500"),
                        Optional.of(ONCE),
                        Optional.empty());
    }

    @Test
    void runTransaction() {
        Response response = new Bills().runTransaction(billRequest);
        Assertions.assertEquals("success", response.getStatus());

        getStatus(response.getData().getId());
    }

    @Test
    void runBulkTransaction() {
        List<BillRequest> billRequestList = new ArrayList<>();
        billRequestList.add(billRequest);

        Assertions.assertEquals("success", new Bills().runBulkTransaction(billRequestList).getStatus());
    }

//    @Test
    void getStatus(int id) {
        Assertions.assertEquals("success", new Bills().getStatus(String.valueOf(id)).getStatus());
    }

    @Test
    void getBills() {
        Assertions.assertEquals("success", new Bills().getBills("", "").getStatus());
    }

    @Test
    void validateBillService() {
        Assertions.assertEquals("success", new Bills().validateBillService("AT099",
                "BIL099", "2348109328188").getStatus());
    }

    @Test
    void getCategories() {
        Assertions.assertEquals("success", new Bills().getCategories(Optional.empty(),
                Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(),
                Optional.empty(), Optional.empty()).getStatus());
    }
}