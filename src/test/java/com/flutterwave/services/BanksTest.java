package com.flutterwave.services;

import com.flutterwave.utility.Environment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.flutterwave.utility.Properties.getProperty;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Cleopatra Douglas
 */
class BanksTest {


    @BeforeEach
    void setUp() {
        Environment.setSecretKey(getProperty("SEC_KEY"));
        Environment.setPublicKey(getProperty("PUB_KEY"));
        Environment.setEncryptionKey(getProperty("ENCR_KEY"));
    }

    @Test
    void getBanks() {
        Assertions.assertEquals("success", new Banks().getBanks("NG").getStatus());
    }

    @Test
    void getBankBranches() {
        Assertions.assertEquals("success", new Banks().getBankBranches(280).getStatus());
    }
}