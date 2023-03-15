package com.flutterwave.services;

import com.flutterwave.bean.*;
import com.flutterwave.bean.MobileMoneyRequest;
import com.flutterwave.utility.Environment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Optional;

import static com.flutterwave.utility.Properties.getProperty;

/**
 * @author Cleopatra Douglas
 */
class MobileMoneyRequestTest {
    MpesaRequest mpesaRequest;
    GhanaMobileMoneyRequestRequest ghanaMobileMoneyRequest;
    UgandaMobileMoneyRequestRequest ugandaMobileMoneyRequest;
    FrancophoneMobileMoneyRequestRequest francophoneMobileMoneyRequest;
    RwandaMobileMoneyRequestRequest rwandaMobileMoneyRequest;
    ZambiaMobileMoneyRequestRequest zambiaMobileMoneyRequest;

    @BeforeEach
    void setUp() {
        Environment.setSecretKey(getProperty("SECRET_KEY"));
        Environment.setPublicKey(getProperty("PUBLIC_KEY"));
        Environment.setEncryptionKey(getProperty("ENCRYPTION_KEY"));

        mpesaRequest = new MpesaRequest("MC-15852113s09v5050e8",
                new BigDecimal("10"),
                "KES",
                "stefan.wexler@hotmail.eu",
                "25454709929220",
                "Yolande Aglaé Colbert");

        ghanaMobileMoneyRequest = new GhanaMobileMoneyRequestRequest("MC-158523s09v5050e8",
                new BigDecimal("150"),
                "GHS",
                "143256743",
                "MTN",
                "stefan.wexler@hotmail.eu",
                "054709929220",
                "Yolande Aglaé Colbert",
                "154.123.220.1",
                "62wd23423rq324323qew1",
                Optional.empty());

        ugandaMobileMoneyRequest = new UgandaMobileMoneyRequestRequest("MC-158523s09v5050e8",
                new BigDecimal("150"),
                "UGX",
                "143256743",
                "MTN",
                "stefan.wexler@hotmail.eu",
                "054709929220",
                "Yolande Aglaé Colbert",
                "154.123.220.1",
                "62wd23423rq324323qew1",
                Optional.empty());

        francophoneMobileMoneyRequest = new FrancophoneMobileMoneyRequestRequest("MC-15852113s09v5050e8",
                new BigDecimal("10"),
                "CM",
                "XAF",
                "stefan.wexler@hotmail.eu",
                "25454709929220",
                "Yolande Aglaé Colbert");

        rwandaMobileMoneyRequest = new RwandaMobileMoneyRequestRequest("MC-15852113s09v5050e8",
                new BigDecimal("10"),
                "KES",
                "stefan.wexler@hotmail.eu",
                "25454709929220",
                "Yolande Aglaé Colbert");

        zambiaMobileMoneyRequest = new ZambiaMobileMoneyRequestRequest("MC-158523s09v5050e8",
                new BigDecimal("150"),
                "UGX",
                "143256743",
                "MTN",
                "stefan.wexler@hotmail.eu",
                "054709929220",
                "Yolande Aglaé Colbert",
                "154.123.220.1",
                "62wd23423rq324323qew1",
                Optional.empty());


    }

    @Test
    void runMpesaTransaction() {
        Assertions.assertEquals("success", new MobileMoney().runMpesaTransaction(mpesaRequest).getStatus());
    }

    @Test
    void runGhanaMobileMoneyTransaction() {
        Assertions.assertEquals("success", new MobileMoney().runGhanaMobileMoneyTransaction(ghanaMobileMoneyRequest).getStatus());
    }

    @Test
    void runUgandaMobileMoneyTransaction() {
        Assertions.assertEquals("success", new MobileMoney().runUgandaMobileMoneyTransaction(ugandaMobileMoneyRequest).getStatus());
    }

    @Test
    void runFrancophoneMobileMoneyTransaction() {
        Assertions.assertEquals("success", new MobileMoney().runFrancophoneMobileMoneyTransaction(francophoneMobileMoneyRequest).getStatus());
    }

    @Test
    void runRwandaMobileMoneyTransaction() {
        Assertions.assertEquals("success", new MobileMoney().runRwandaMobileMoneyTransaction(rwandaMobileMoneyRequest).getStatus());
    }

    @Test
    void runZambiaMobileMoneyTransaction() {
        Assertions.assertEquals("success", new MobileMoney().runZambiaMobileMoneyTransaction(zambiaMobileMoneyRequest).getStatus());
    }
}