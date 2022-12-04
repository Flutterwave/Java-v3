package com.flutterwave.services;

import com.flutterwave.bean.USSDRequest;
import com.flutterwave.utility.Environment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Cleopatra Douglas
 */
class USSDTest {
    USSDRequest ussdRequest;

    @BeforeEach
    void setUp() {


        ussdRequest = new USSDRequest("MC-15852309v5050e8y",
                "057",
                new BigDecimal("10"),
                "NGN",
                "stefan.wexler@hotmail.eu",
                "054709929220",
                "Yolande Aglaé Colbert");
    }

    @Test
    void runTransaction() {

        Assertions.assertEquals("success", new USSD().runTransaction(ussdRequest).getStatus());
    }
}