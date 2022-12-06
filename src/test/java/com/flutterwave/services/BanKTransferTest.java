package com.flutterwave.services;

import com.flutterwave.bean.BanKTransferRequest;
import com.flutterwave.bean.BankAccountRequest;
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
class BanKTransferTest {
    BanKTransferRequest banKTransferRequest;

    @BeforeEach
    void setUp() {
        Environment.setSecretKey("FLWSECK_TEST-92e9c22c37f997c5119d816c5c99981b-X");
        Environment.setEncryptionKey("FLWSECK_TESTf9d732d1c1f2");

        banKTransferRequest = new BanKTransferRequest(Optional.empty(),
                "ref001",
                Optional.of(new BigDecimal("10")),
                "stefan.wexler@hotmail.eu",
                Optional.empty(),
                "NGN",
                "154.123.220.1",
                "62wd23423rq324323qew1",
                "FlW Devs",
                Optional.empty());
    }

    @Test
    void runTransaction() {
        Assertions.assertEquals("success", new BanKTransfer().runTransaction(banKTransferRequest).getStatus());
    }
}