package com.flutterwave.services;

import com.flutterwave.bean.BankAccountRequest;
import com.flutterwave.utility.Environment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static com.flutterwave.utility.Properties.getProperty;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Cleopatra Douglas
 */
class BankAccountTest {

    BankAccountRequest NGNbankAccountRequest;
    BankAccountRequest UKbankAccountRequest;

    @BeforeEach
    void setUp() {
        Environment.setSecretKey(getProperty("SEC_KEY"));
        Environment.setPublicKey(getProperty("PUB_KEY"));
        Environment.setEncryptionKey(getProperty("ENCR_KEY"));

        NGNbankAccountRequest = new BankAccountRequest("MC-1585230ew9v5050e8",
                new BigDecimal("100"),
                "058",
                "0690000032",
                "NGN",
                "stefan.wexler@hotmail.eu",
                "0902620185",
                "Yolande Aglaé Colbert");

        UKbankAccountRequest = new BankAccountRequest("MC-1585230ew9v5050e8",
                new BigDecimal("100"),
                "044",
                "0690000032",
                "GBP",
                "stefan.wexler@hotmail.eu",
                "0902620185",
                "Yolande Aglaé Colbert");
    }

    @Test
    void runNGNTransaction() {
        Assertions.assertEquals("error", new BankAccount().runTransaction(NGNbankAccountRequest).getStatus());
    }

    @Test
    void runUKTransaction() {
        Assertions.assertEquals("error", new BankAccount().runTransaction(UKbankAccountRequest).getStatus());
    }
}