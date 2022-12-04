package com.flutterwave.services;

import com.flutterwave.bean.Authorization;
import com.flutterwave.bean.CardRequest;
import com.flutterwave.bean.Response;
import com.flutterwave.utility.Environment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Optional;

import static com.flutterwave.bean.ChargeTypes.CARD;

class CardChargeTest {
    CardRequest cardRequest;

    @BeforeEach
    void setUp() {
        Environment.setSecretKey("FLWSECK_TEST-92e9c22c37f997c5119d816c5c99981b-X");
        Environment.setEncryptionKey("FLWSECK_TESTf9d732d1c1f2");


        cardRequest = new CardRequest("5531886652142950",
                "564",
                "09",
                "32",
                "NGN",
                new BigDecimal("100"),
                "Yolande Aglaé Colbert",
                "stefan.wexler@hotmail.eu",
                "MC-3243e8",
                "https://www,flutterwave.ng",
                null);
    }

    @Test
    void runTransaction() {
        Assertions.assertEquals("success", new CardCharge().runTransaction(cardRequest).getStatus());
    }

    @Test
    void authorizeTransactionPin() {
        cardRequest.setAuthorization(new Authorization().pinAuthorization("3306"));
        Response response = new CardCharge().runTransaction(cardRequest);
        Assertions.assertEquals("success", response.getStatus());

        //validate
        validateTransaction(response.getData().getFlw_ref());

        //verify
        verifyTransaction(response.getData().getId());
    }

    void validateTransaction(String flw_ref) {
        cardRequest.setAuthorization(new Authorization().pinAuthorization("3306"));
        Assertions.assertEquals("success", new ValidateCharge("1111", flw_ref, Optional.of(CARD)).runTransaction().getStatus());
    }

    void verifyTransaction(int id) {
        Assertions.assertEquals("success", new Transactions().runVerifyTransaction(id).getStatus());
    }
}