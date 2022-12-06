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


        bvn = "123456789010";
    }

    @Test
    void runTransaction() {
        Assertions.assertEquals("success", new ResolveBVN().runTransaction(bvn).getStatus());
    }
}