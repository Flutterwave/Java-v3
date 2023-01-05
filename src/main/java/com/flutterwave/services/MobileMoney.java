package com.flutterwave.services;

import com.flutterwave.bean.*;

import java.util.Optional;

import static com.flutterwave.bean.ChargeTypes.*;

/**
 * Collect payments via various mobile money channels
 * @author cleopatradouglas
 */
public class MobileMoney extends Charge{

    /**
     * This payment method allows you to receive KES payments via Mpesa.
     * @param mpesaRequest bean
     * @return Response
     */
    public Response runMpesaTransaction(MpesaRequest mpesaRequest){
        return runTransaction(mpesaRequest.toString(), MPESA, false, Optional.empty());
    }

    /**
     * This payment method allows you to recieve GHS payments via Mobile Money.
     * @param ghanaMobileMoneyRequest bean
     * @return Response
     */
    public Response runGhanaMobileMoneyTransaction(GhanaMobileMoneyRequestRequest ghanaMobileMoneyRequest){
        return runTransaction(ghanaMobileMoneyRequest.toString(), MOBILE_MONEY_GHANA, false, Optional.empty());
    }

    /**
     * This payment method allows you to receive payments via Uganda Mobile Money.
     * @param ugandaMobileMoneyRequest bean
     * @return Response
     */
    public Response runUgandaMobileMoneyTransaction(UgandaMobileMoneyRequestRequest ugandaMobileMoneyRequest){
        return runTransaction(ugandaMobileMoneyRequest.toString(), MOBILE_MONEY_UGANDA, false, Optional.empty());
    }

    /**
     *This payment method allows you to collect payments via mobile money in Francophone countries.
     * @param francophoneMobileMoneyRequest bean
     * @return Response
     */
    public Response runFrancophoneMobileMoneyTransaction(FrancophoneMobileMoneyRequestRequest francophoneMobileMoneyRequest){
        return runTransaction(francophoneMobileMoneyRequest.toString(), MOBILE_MONEY_FRANCO, false, Optional.empty());
    }

    /**
     * This payment method allows you to collect payments via Rwandan Mobile Money.
     * @param rwandaMobileMoneyRequest bean
     * @return Response
     */
    public Response runRwandaMobileMoneyTransaction(RwandaMobileMoneyRequestRequest rwandaMobileMoneyRequest){
        return runTransaction(rwandaMobileMoneyRequest.toString(), MOBILE_MONEY_RWANDA, false, Optional.empty());
    }

    /**
     * This payment method allows you to collect payments via Zambia Mobile Money.
     * @param zambiaMobileMoneyRequest bean
     * @return Response
     */
    public Response runZambiaMobileMoneyTransaction(ZambiaMobileMoneyRequestRequest zambiaMobileMoneyRequest){
        return runTransaction(zambiaMobileMoneyRequest.toString(), MOBILE_MONEY_ZAMBIA, false, Optional.empty());
    }
}
