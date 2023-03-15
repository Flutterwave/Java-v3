package com.flutterwave.services;

import com.flutterwave.bean.Meta;
import com.flutterwave.bean.PreAuthorizationRequest;
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
class PreAuthorizationTest {
    PreAuthorizationRequest preAuthorizationRequest;

    @BeforeEach
    void setUp() {
        Environment.setSecretKey(getProperty("SECRET_KEY"));
        Environment.setPublicKey(getProperty("PUBLIC_KEY"));
        Environment.setEncryptionKey(getProperty("ENCRYPTION_KEY"));

        preAuthorizationRequest = new PreAuthorizationRequest(
                "5531886652142950",
                "157",
                "5",
                "25",
                new BigDecimal("20"),
                "Flutterwave Developers",
                "sample-ref",
                "NGN",
                "NG",
                "developers@flutterwavego.com",
                "https://www.flutterwave.com/ng/",
                Optional.empty());

    }

    @Test
    void runTransaction() {
        Assertions.assertEquals("success", new PreAuthorization().runTransaction(preAuthorizationRequest).getStatus());
    }

    @Test
    void runCaptureTransaction() {
        Assertions.assertEquals("success", new PreAuthorization().runCaptureTransaction("sample-ref", new BigDecimal("20")).getStatus());
    }

    @Test
    void runPaypalCaptureTransaction() {
        Assertions.assertEquals("success", new PreAuthorization().runPaypalCaptureTransaction("sampleRef134").getStatus());
    }

    @Test
    void runVoidTransaction() {
        Assertions.assertEquals("success", new PreAuthorization().runVoidTransaction("sampleRef134").getStatus());
    }

    @Test
    void runPaypalVoidTransaction() {
        Assertions.assertEquals("success", new PreAuthorization().runPaypalVoidTransaction("sampleRef134").getStatus());
    }

    @Test
    void runRefundTransaction() {
        Assertions.assertEquals("success", new PreAuthorization().runRefundTransaction("sampleRef134", new BigDecimal("20")).getStatus());
    }
}