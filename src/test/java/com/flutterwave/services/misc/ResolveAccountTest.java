package com.flutterwave.services.misc;

import com.flutterwave.bean.AccountResolveRequest;
import com.flutterwave.bean.ChargeTypes;
import com.flutterwave.services.GooglePay;
import com.flutterwave.utility.Environment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Cleopatra Douglas
 */
class ResolveAccountTest {
    AccountResolveRequest accountResolveRequest;

    @BeforeEach
    void setUp() {
        Environment.setSecretKey("FLWSECK_TEST-92e9c22c37f997c5119d816c5c99981b-X");
        Environment.setEncryptionKey("FLWSECK_TESTf9d732d1c1f2");

        accountResolveRequest = new AccountResolveRequest(
                "0690000032",
                "044",
                Optional.empty(),
                Optional.empty()
                );
    }

    @Test
    void runTransaction() {

        Assertions.assertEquals("success", new ResolveAccount().runTransaction(accountResolveRequest).getStatus());
    }
}