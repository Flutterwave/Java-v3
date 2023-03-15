package com.flutterwave.services;

import com.flutterwave.bean.PaypalRequest;
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
class PaypalTest {

    PaypalRequest paypalRequest;

    @BeforeEach
    void setUp() {
        Environment.setSecretKey(getProperty("SECRET_KEY"));
        Environment.setPublicKey(getProperty("PUBLIC_KEY"));
        Environment.setEncryptionKey(getProperty("ENCRYPTION_KEY"));

        paypalRequest = new PaypalRequest(
                "John Madakin",
                "Robert K Gagne",
                "1010  Woodrow Way",
                "Lufkin",
                "75904",
                "Texas",
                "US",
                "PayPalv3Test03",
                new BigDecimal("10"),
                "dovedom221@vss6.com",
                "054222234847",
                "USD",
                "154.123.220.1",
                "62wd23423rq324323qew1",
                "15101",
                "Allison park",
                "3563 Huntertown Rd",
                "Pensylvannia",
                "US",
                "http://johnmadakin.com/u/payment-completed",
                Optional.empty());

    }

    @Test
    void runTransaction() {
        Assertions.assertEquals("error", new Paypal().runTransaction(paypalRequest).getStatus());
    }
}