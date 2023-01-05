package com.flutterwave.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Cleopatra Douglas
 */
class SubscriptionsTest {

    @BeforeEach
    void setUp() {
        Environments.setUp();
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