package com.flutterwave.services;

import com.flutterwave.bean.ApplePayRequest;
import com.flutterwave.bean.GooglePayRequest;
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
class GooglePayTest {
    GooglePayRequest googlePayRequest;

    @BeforeEach
    void setUp() {

        Environment.setSecretKey(getProperty("SEC_KEY"));
        Environment.setPublicKey(getProperty("PUB_KEY"));
        Environment.setEncryptionKey(getProperty("ENCR_KEY"));

        googlePayRequest= new GooglePayRequest("MC-TEST-123456",
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
        Assertions.assertEquals("success", new GooglePay().runTransaction(googlePayRequest).getStatus());
    }
}