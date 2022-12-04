package com.flutterwave.services;

import com.flutterwave.bean.*;

import java.util.Optional;

import static com.flutterwave.bean.ChargeTypes.*;

public class MobileMoney extends Charge{

    public Response runMpesaTransaction(MpesaRequest mpesaRequest){
        return runTransaction(mpesaRequest.toString(), MPESA, false, Optional.empty());
    }

    public Response runGhanaMobileMoneyTransaction(GhanaMobileMoneyRequestRequest ghanaMobileMoneyRequest){
        return runTransaction(ghanaMobileMoneyRequest.toString(), MOBILE_MONEY_GHANA, false, Optional.empty());
    }

    public Response runUgandaMobileMoneyTransaction(UgandaMobileMoneyRequestRequest ugandaMobileMoneyRequest){
        return runTransaction(ugandaMobileMoneyRequest.toString(), MOBILE_MONEY_UGANDA, false, Optional.empty());
    }

    public Response runFrancophoneMobileMoneyTransaction(FrancophoneMobileMoneyRequestRequest francophoneMobileMoneyRequest){
        return runTransaction(francophoneMobileMoneyRequest.toString(), MOBILE_MONEY_FRANCO, false, Optional.empty());
    }

    public Response runRwandaMobileMoneyTransaction(RwandaMobileMoneyRequestRequest rwandaMobileMoneyRequest){
        return runTransaction(rwandaMobileMoneyRequest.toString(), MOBILE_MONEY_RWANDA, false, Optional.empty());
    }

    public Response runZambiaMobileMoneyTransaction(ZambiaMobileMoneyRequestRequest zambiaMobileMoneyRequest){
        return runTransaction(zambiaMobileMoneyRequest.toString(), MOBILE_MONEY_ZAMBIA, false, Optional.empty());
    }
}
