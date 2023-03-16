package com.flutterwave.services;

import com.flutterwave.bean.PaymentPlanRequest;
import com.flutterwave.bean.UpdatePaymentPlanRequest;
import com.flutterwave.utility.Environment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static com.flutterwave.bean.Recurrence.MONTHLY;
import static com.flutterwave.utility.Properties.getProperty;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Cleopatra Douglas
 */
class PaymentPlanTest {
    PaymentPlanRequest paymentPlanRequest;
    UpdatePaymentPlanRequest UpdatePaymentPlanRequest;

    @BeforeEach
    void setUp() {
        Environment.setSecretKey(getProperty("SEC_KEY"));
        Environment.setPublicKey(getProperty("PUB_KEY"));
        Environment.setEncryptionKey(getProperty("ENCR_KEY"));

        paymentPlanRequest = new PaymentPlanRequest(new BigDecimal("5000"),
                "the akhlm postman plan 2",
                MONTHLY,
                40);

        UpdatePaymentPlanRequest = new UpdatePaymentPlanRequest("January neighbourhood contribution",
                "active");

    }

    @Test
    void runCreatePlan() {
        Assertions.assertEquals("success", new PaymentPlan().runCreatePlan(paymentPlanRequest).getStatus());
    }

    @Test
    void getPlans() {
        Assertions.assertEquals("success", new PaymentPlan().getPlans().getStatus());
    }

    @Test
    void getPlan() {
        Assertions.assertEquals("success", new PaymentPlan().getPlan(30980).getStatus());
    }

    @Test
    void cancelPlan() {
        Assertions.assertEquals("success", new PaymentPlan().cancelPlan(0).getStatus());
    }

    @Test
    void updatePlan() {
        Assertions.assertEquals("success", new PaymentPlan().updatePlan(30980, UpdatePaymentPlanRequest).getStatus());
    }
}