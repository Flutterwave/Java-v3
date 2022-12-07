package com.flutterwave.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Cleopatra Douglas
 */
class SettlementsTest {

    @Test
    void runGetAllSettlements() {
        Assertions.assertEquals("success", new Settlements().runGetAllSettlements(Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty()).getStatus());
    }

    @Test
    void runGetSettlement() {
        Assertions.assertEquals("success", new Settlements().runGetSettlement(0,
                Optional.empty(),
                Optional.empty()).getStatus());
    }
}