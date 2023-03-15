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
import static com.flutterwave.utility.Properties.getProperty;

class CardChargeTest {
    CardRequest cardRequest;

    @BeforeEach
    void setUp() {

        Environment.setSecretKey(getProperty("SEC_KEY"));
        Environment.setPublicKey(getProperty("PUB_KEY"));
        Environment.setEncryptionKey(getProperty("ENCR_KEY"));

        cardRequest = new CardRequest("5438898014560229",
                "564",
                "09",
                "32",
                "NGN",
                new BigDecimal("100.88"),
                "Yolande Aglaé Colbert",
                "tafchaty@gmail.com",
                "javasdk-test",
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
                        case PIN -> cardRequest.setAuthorization(new Authorization().pinAuthorization("3310"));
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
                    System.out.println("authorizeResponse response ==>" + authorizeResponse);

                    Assertions.assertEquals("success", authorizeResponse.getStatus());

                    //validate
                    validateTransaction(authorizeResponse.getData().getFlw_ref());

                    //verify
                    verifyTransaction(authorizeResponse.getData().getId());
                    //Response verifyResponse = new CardCharge().(cardRequest);
                    //System.out.println("verifyResponse response ==>" + verifyResponse);
                    return null;
                });
    }

    void validateTransaction(String flw_ref) {
        cardRequest.setAuthorization(new Authorization().pinAuthorization("3310"));
        Assertions.assertEquals("success", new ValidateCharge("12345", flw_ref, Optional.of(CARD)).runTransaction().getStatus());
    }

    void verifyTransaction(int id) {
        Assertions.assertEquals("success", new Transactions().runVerifyTransaction(id).getStatus());
    }
}