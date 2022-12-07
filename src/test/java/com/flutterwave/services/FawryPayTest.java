package com.flutterwave.services;

import com.flutterwave.bean.FawryPayRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Cleopatra Douglas
 */
class FawryPayTest {

    FawryPayRequest fawryPayRequest;

    @BeforeEach
    void setUp() {
        Environments.setUp();

        fawryPayRequest = new FawryPayRequest("fawrySample1",
                new BigDecimal("10"),
                "user@flw.com",
                "EGP",
                "09012345678",
                "https://www.flutterwave.com",
                Optional.empty());

    }

    @Test
    void runTransaction() {
        Assertions.assertEquals("success", new FawryPay().runTransaction(fawryPayRequest).getStatus());
    }
}