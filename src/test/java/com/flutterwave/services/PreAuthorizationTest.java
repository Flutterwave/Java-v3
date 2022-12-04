package com.flutterwave.services;

import com.flutterwave.bean.Meta;
import com.flutterwave.bean.PreAuthorizationRequest;
import com.flutterwave.utility.Environment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Cleopatra Douglas
 */
class PreAuthorizationTest {
    PreAuthorizationRequest preAuthorizationRequest;

    @BeforeEach
    void setUp() {
        Environment.setSecretKey("FLWSECK_TEST-92e9c22c37f997c5119d816c5c99981b-X");
        Environment.setEncryptionKey("FLWSECK_TESTf9d732d1c1f2");


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
        Assertions.assertEquals("success", new PreAuthorization().runCaptureTransaction("sampleRef134", new BigDecimal("20")).getStatus());
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