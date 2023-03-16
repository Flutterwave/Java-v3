package com.flutterwave.services;

import com.flutterwave.bean.ApplePayRequest;
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
class ApplePayTest {

    ApplePayRequest applePayRequest;

    @BeforeEach
    void setUp() {
        Environment.setSecretKey(getProperty("SEC_KEY"));
        Environment.setPublicKey(getProperty("PUB_KEY"));
        Environment.setEncryptionKey(getProperty("ENCR_KEY"));

        applePayRequest= new ApplePayRequest("MC-TEST-122324353456",
                new BigDecimal("10"),
                "stefan.wexler@hotmail.eu",
                "09012345678",
                "USD",
                "192.168.0.1",
                "gdgdhdh738bhshsjs",
                "15101",
                "allison park",
                "3563 Huntertown Rd",
                "Pennsylvania",
                "US",
                "Test payment",
                Optional.empty());
    }

    @Test
    void runTransaction() {
        Assertions.assertEquals("success", new ApplePay().runTransaction(applePayRequest).getStatus());
    }
}