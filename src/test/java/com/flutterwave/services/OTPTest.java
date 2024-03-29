package com.flutterwave.services;

import com.flutterwave.bean.Customer;
import com.flutterwave.bean.Medium;
import com.flutterwave.bean.OTPRequest;
import com.flutterwave.utility.Environment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.flutterwave.bean.Medium.SMS;
import static com.flutterwave.utility.Properties.getProperty;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Cleopatra Douglas
 */
class OTPTest {
    OTPRequest otpRequest;

    @BeforeEach
    void setUp() {
        Environment.setSecretKey(getProperty("SEC_KEY"));
        Environment.setPublicKey(getProperty("PUB_KEY"));
        Environment.setEncryptionKey(getProperty("ENCR_KEY"));

        List<Medium> mediumList = new ArrayList<>();
        mediumList.add(SMS);

        otpRequest = new OTPRequest(new Customer(
                "Flutterwave Developers",
                "developers@flutterwavego.com",
                "2348000000000"),
                "Flutterwave Inc.",
                true,
                7,
                Optional.of(3),
                mediumList);
    }

    @Test
    void runCreateOTP() {
        Assertions.assertEquals("success", new OTP().runCreateOTP(otpRequest).getStatus());
    }

    @Test
    void runValidateOTP(){
        Assertions.assertEquals("success", new OTP().runValidateOTP("CF-BARTER-20221203111843688560", "6834919").getStatus());
    }
}