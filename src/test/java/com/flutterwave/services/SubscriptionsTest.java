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
class SubscriptionsTest {

    @BeforeEach
    void setUp() {
        Environment.setSecretKey(getProperty("SEC_KEY"));
        Environment.setPublicKey(getProperty("PUB_KEY"));
        Environment.setEncryptionKey(getProperty("ENCR_KEY"));
    }

//
//    @Test
//    void getAllSubscriptions() {
//        Assertions.assertEquals("success", new Subscriptions().getAllSubscriptions().getStatus());
//    }

    @Test
    void activateSubscription() {
        Assertions.assertEquals("success", new Subscriptions().activateSubscription(0).getStatus());
    }

    @Test
    void deactivateSubscription() {
        Assertions.assertEquals("success", new Subscriptions().deactivateSubscription(0).getStatus());
    }
}