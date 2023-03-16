package com.flutterwave.services;

import com.flutterwave.bean.FawryPayRequest;
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
class FawryPayTest {

    FawryPayRequest fawryPayRequest;

    @BeforeEach
    void setUp() {
        Environment.setSecretKey(getProperty("SEC_KEY"));
        Environment.setPublicKey(getProperty("PUB_KEY"));
        Environment.setEncryptionKey(getProperty("ENCR_KEY"));

        fawryPayRequest = new FawryPayRequest("fawrySample1",
                new BigDecimal("10"),
                "user@flw.com",
                "09012345678",
                "EGP",
                "https://www.flutterwave.com",
                Optional.empty());

    }

    @Test
    void runTransaction() {
        Assertions.assertEquals("success", new FawryPay().runTransaction(fawryPayRequest).getStatus());
    }
}