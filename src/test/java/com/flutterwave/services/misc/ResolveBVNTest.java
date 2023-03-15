package com.flutterwave.services.misc;

//import com.flutterwave.services.Environments;
import com.flutterwave.utility.Environment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.flutterwave.utility.Properties.getProperty;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Cleopatra Douglas
 */
class ResolveBVNTest {

private String bvn;
    @BeforeEach
    void setUp() {
        Environment.setSecretKey(getProperty("SEC_KEY"));
        Environment.setPublicKey(getProperty("PUB_KEY"));
        Environment.setEncryptionKey(getProperty("ENCR_KEY"));

        bvn = "123456789010";
    }

    @Test
    void runTransaction() {
        Assertions.assertEquals("error", new ResolveBVN().runTransaction(bvn).getStatus());
    }
}