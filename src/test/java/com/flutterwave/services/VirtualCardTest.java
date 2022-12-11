package com.flutterwave.services;

import com.flutterwave.bean.FundVirtualCardRequest;
import com.flutterwave.bean.VirtualCardRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static com.flutterwave.bean.Actions.BLOCK;

/**
 * @author Cleopatra Douglas
 */
class VirtualCardTest {
    VirtualCardRequest virtualCardRequest;
    FundVirtualCardRequest fundVirtualCardRequest;

    @BeforeEach
    void setUp() {
        Environments.setUp();

        virtualCardRequest = new VirtualCardRequest("USD",
                new BigDecimal("1"),
                "NGN",
                "Example User.",
                "333, Fremont Street",
                "San Francisco",
                "CA",
                "94105",
                "US",
                "Example",
                "User",
                "1996/12/30",
                "userg@example.com",
                "07030000000",
                "MR",
                "M",
                "https://webhook.site/b67965fa-e57c-4dda-84ce-0f8d6739b8a5");

        fundVirtualCardRequest = new FundVirtualCardRequest(
                "USD",
                new BigDecimal("500"));

    }

    @Test
    void runCreateVirtualCard() {
        Assertions.assertEquals("success", new VirtualCard().runCreateVirtualCard(virtualCardRequest).getStatus());
    }

    @Test
    void runGetAllVirtualCards() {
        Assertions.assertEquals("success", new VirtualCard().runGetAllVirtualCards().getStatus());
    }

    @Test
    void runGetVirtualCard() {
        Assertions.assertEquals("success", new VirtualCard().runGetVirtualCard("").getStatus());
    }

    @Test
    void runFundVirtualCard() {
        Assertions.assertEquals("success", new VirtualCard()
                .runFundVirtualCard("", fundVirtualCardRequest).getStatus());
    }

    @Test
    void runWithdrawVirtualCard() {
        Assertions.assertEquals("success", new VirtualCard()
                .runWithdrawVirtualCard("", new BigDecimal("200")).getStatus());
    }

    @Test
    void runStatusVirtualCard() {
        Assertions.assertEquals("success", new VirtualCard().runStatusVirtualCard("", BLOCK).getStatus());
    }

    @Test
    void runTerminateVirtualCard() {
        Assertions.assertEquals("success", new VirtualCard().runTerminateVirtualCard("").getStatus());
    }

    @Test
    void runGetTransactions() {
        Assertions.assertEquals("success", new VirtualCard()
                .runGetTransactions("", "", "", 0, 0).getStatus());
    }
}