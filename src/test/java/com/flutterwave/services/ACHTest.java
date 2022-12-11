package com.flutterwave.services;

import com.flutterwave.bean.ACHRequest;
import com.flutterwave.bean.Meta;
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
class ACHTest {

    ACHRequest achRequest;

    @BeforeEach
    void setUp() {
        Environments.setUp();

        achRequest = new ACHRequest("MC-1585230ew9v5050e8",
                new BigDecimal("100"),
                "stefan.wexler@hotmail.eu",
                "0902620185",
                "USD",
                "US",
                "154.123.220.1",
                "Yolande Aglaé Colbert",
                "https://www.flutterwave.com/us/",
                "62wd23423rq324323qew1",
                Optional.empty());
    }

    @Test
    void runTransaction() {
        Assertions.assertEquals("error", new ACH().runTransaction(achRequest).getStatus());
    }
}