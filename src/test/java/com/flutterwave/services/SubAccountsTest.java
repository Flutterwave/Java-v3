package com.flutterwave.services;

import com.flutterwave.bean.*;
import com.flutterwave.utility.Environment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Optional;

import static com.flutterwave.bean.SubAccountTypes.COLLECTION;
import static com.flutterwave.bean.SubAccountTypes.PAYOUT;
import static com.flutterwave.utility.Properties.getProperty;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Cleopatra Douglas
 */
class SubAccountsTest {
    UpdateCollectionSubAccountRequest updateCollectionSubAccountRequest;
    UpdatePayoutSubAccountRequest updatePayoutSubAccountRequest;
    PayoutSubAccountRequest payoutSubAccountRequest;
    CollectionsSubAccountRequest collectionsSubAccountRequest;

    @BeforeEach
    void setUp() {
        Environment.setSecretKey(getProperty("SEC_KEY"));
        Environment.setPublicKey(getProperty("PUB_KEY"));
        Environment.setEncryptionKey(getProperty("ENCR_KEY"));

        collectionsSubAccountRequest = new CollectionsSubAccountRequest("044",
                "0690000037",
                "Eternal Blue",
                "petya@stux.net",
                "Anonymous",
                "090890382",
                "09087930450",
                "NG",
                Optional.empty(),
                "percentage",
                new BigDecimal("0.5"));


        updateCollectionSubAccountRequest = new UpdateCollectionSubAccountRequest(
                new BigDecimal("200"),
                Optional.of("mad@o.enterprises"),
                Optional.of("044"),
                Optional.of("0690000040"),
                Optional.of("flat"));
    }

    @Test
    void runCreateSubAccounts() {
        Assertions.assertEquals("success", new SubAccounts().runCreateSubAccounts(collectionsSubAccountRequest,
                Optional.empty(),
                COLLECTION).getStatus());
    }

    @Test
    void runGetCollectionSubAccounts() {
        Assertions.assertEquals("success", new SubAccounts().runGetSubAccounts(
                Optional.of("044"),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                COLLECTION).getStatus());
    }

    @Test
    void runGetPayoutSubAccounts() {
        Assertions.assertEquals("success", new SubAccounts().runGetSubAccounts(
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                PAYOUT).getStatus());
    }

    @Test
    void runGetCollectionSubAccount() {
        Assertions.assertEquals("success", new SubAccounts().runGetSubAccount(18504,
                Optional.empty(),
                Optional.empty(),
                COLLECTION).getStatus());
    }


    @Test
    void updateSubAccount() {
        Assertions.assertEquals("success", new SubAccounts().updateSubAccount(18504,
                updateCollectionSubAccountRequest,
                Optional.empty(),
                Optional.empty(),
                COLLECTION).getStatus());
    }

    @Test
    void runDeleteCollectionSubAccounts() {
        Assertions.assertEquals("success", new SubAccounts().runDeleteCollectionSubAccounts(18504).getStatus());
    }

    @Test
    void runGetPayoutSubAccountTransactions() {
        Assertions.assertEquals("success", new SubAccounts().runGetPayoutSubAccountTransactions("18504",
        "", "", "").getStatus());
    }

    @Test
    void runGetPayoutSubAccountBalance() {
        Assertions.assertEquals("success", new SubAccounts().runGetPayoutSubAccountBalance("", "").getStatus());
    }

    @Test
    void runGetPayoutSubAccountStaticVirtualAccount() {
        Assertions.assertEquals("success", new SubAccounts().runGetPayoutSubAccountStaticVirtualAccount("", "").getStatus());
    }
}