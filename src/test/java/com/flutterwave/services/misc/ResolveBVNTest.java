package com.flutterwave.services.misc;

import com.flutterwave.utility.Environment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Cleopatra Douglas
 */
class ResolveBVNTest {

private String bvn;
    @BeforeEach
    void setUp() {
        Environment.setSecretKey("FLWSECK_TEST-92e9c22c37f997c5119d816c5c99981b-X");
        Environment.setEncryptionKey("FLWSECK_TESTf9d732d1c1f2");

        bvn = "123456789010";
    }

    @Test
    void runTransaction() {
        Assertions.assertEquals("success", new ResolveBVN().runTransaction(bvn).getStatus());
    }
}