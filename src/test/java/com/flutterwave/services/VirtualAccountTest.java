package com.flutterwave.services;

import com.flutterwave.bean.Response;
import com.flutterwave.bean.VirtualAccountRequest;
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
class VirtualAccountTest {
    VirtualAccountRequest virtualAccountRequest;

    @BeforeEach
    void setUp() {
        Environment.setSecretKey(getProperty("SEC_KEY"));
        Environment.setPublicKey(getProperty("PUB_KEY"));
        Environment.setEncryptionKey(getProperty("ENCR_KEY"));

        virtualAccountRequest = new VirtualAccountRequest("developers@flutterwavego.com",
                Optional.of("12345678901"),
                Optional.of(new BigDecimal("10")),
                "VA12",
                Optional.of(true),
                "Angela");

    }

    @Test
    void runTransaction() {
        Response response = new VirtualAccount().runTransaction(virtualAccountRequest);
        Assertions.assertEquals("success", response.getStatus());

        //getVirtualAccount
        getVirtualAccount(response.getData().getFlw_ref());
    }

    @Test
    void runBulkTransaction() {
    }

    @Test
    void getBulkVirtualAccounts() {
    }

    void getVirtualAccount(String reference) {
        Assertions.assertEquals("success", new VirtualAccount().getVirtualAccount(reference).getStatus());
    }

    @Test
    void updateBVN() {
        Assertions.assertEquals("success", new VirtualAccount().updateBVN("", "").getStatus());
    }

    @Test
    void deleteVirtualAccount() {
    }
}