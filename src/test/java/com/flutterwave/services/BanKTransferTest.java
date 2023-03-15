package com.flutterwave.services;

import com.flutterwave.bean.BanKTransferRequest;
import com.flutterwave.bean.BankAccountRequest;
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
class BanKTransferTest {
    BanKTransferRequest banKTransferRequest;

    @BeforeEach
    void setUp() {
        Environment.setSecretKey(getProperty("SEC_KEY"));
        Environment.setPublicKey(getProperty("PUB_KEY"));
        Environment.setEncryptionKey(getProperty("ENCR_KEY"));
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