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

import static com.flutterwave.bean.AuthorizationModes.PIN;
import static com.flutterwave.bean.ChargeTypes.CARD;

class CardChargeTest {
    CardRequest cardRequest;

    @BeforeEach
    void setUp() {
        Environments.setUp();

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
        Optional.ofNullable(new CardCharge().runTransaction(cardRequest))
                .map(response -> {
                    switch (response.getMeta().getAuthorization().getMode()){
                        case PIN -> cardRequest.setAuthorization(new Authorization().pinAuthorization("3306"));
                        case AUS_NOAUTH -> cardRequest.setAuthorization(new Authorization().avsAuthorization("",
                                "",
                                "",
                                "",
                                ""));
                        case REDIRECT -> {
                            //redirect user
                        }
                    }
                    Response authorizeResponse = new CardCharge().runTransaction(cardRequest);

                    Assertions.assertEquals("success", authorizeResponse.getStatus());

                    //validate
                    validateTransaction(authorizeResponse.getData().getFlw_ref());

                    //verify
                    verifyTransaction(authorizeResponse.getData().getId());
                    return null;
                });
    }

    void validateTransaction(String flw_ref) {
        cardRequest.setAuthorization(new Authorization().pinAuthorization("3306"));
        Assertions.assertEquals("success", new ValidateCharge("1111", flw_ref, Optional.of(CARD)).runTransaction().getStatus());
    }

    void verifyTransaction(int id) {
        Assertions.assertEquals("success", new Transactions().runVerifyTransaction(id).getStatus());
    }
}