package com.flutterwave.services;

import com.flutterwave.bean.BeneficiaryRequest;
import com.flutterwave.utility.Environment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static com.flutterwave.utility.Properties.getProperty;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Cleopatra Douglas
 */
class BeneficiariesTest {
    BeneficiaryRequest beneficiaryRequest;

    @BeforeEach
    void setUp() {
        Environment.setSecretKey(getProperty("SECRET_KEY"));
        Environment.setPublicKey(getProperty("PUBLIC_KEY"));
        Environment.setEncryptionKey(getProperty("ENCRYPTION_KEY"));

        beneficiaryRequest = new BeneficiaryRequest("0690000034",
                "044",
                "Ade Bond",
                Optional.empty(),
                Optional.empty());


    }

    @Test
    void runCreateBeneficiary() {
        Assertions.assertEquals("success", new Beneficiaries().runCreateBeneficiary(beneficiaryRequest).getStatus());
    }

    @Test
    void runGetAllBeneficiaries() {
        Assertions.assertEquals("success", new Beneficiaries().runGetAllBeneficiaries(Optional.empty()).getStatus());
    }

    @Test
    void runGetBeneficiary() {
        Assertions.assertEquals("success", new Beneficiaries().runGetBeneficiary(20505).getStatus());
    }

    @Test
    void runDeleteBeneficiary() {
        Assertions.assertEquals("success", new Beneficiaries().runDeleteBeneficiary(20505).getStatus());
    }
}