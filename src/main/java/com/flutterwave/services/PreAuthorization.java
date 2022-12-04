package com.flutterwave.services;

import com.flutterwave.bean.PreAuthorizationRequest;
import com.flutterwave.bean.Response;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.util.Optional;

import static com.flutterwave.bean.ChargeTypes.CARD;
import static com.flutterwave.bean.PreAuthCommands.*;

/**
 * @author Cleopatra Douglas
 */
public class PreAuthorization extends Charge{

    public Response runTransaction(PreAuthorizationRequest preAuthorizationRequest){
        return runTransaction(preAuthorizationRequest.toString(), CARD, true, Optional.empty());
    }

    public Response runCaptureTransaction(String flw_ref, BigDecimal amount){
        return runTransaction(new JSONObject().put("amount", amount).toString(), CARD, true, Optional.of("/"+flw_ref+"/" + capture));
    }

    public Response runPaypalCaptureTransaction(String flw_ref){
        return runTransaction(new JSONObject().put("flw_ref", flw_ref).toString(), CARD, true, Optional.of("/paypal-capture"));
    }

    public Response runVoidTransaction(String flw_ref){
        return runTransaction(null, CARD, true, Optional.of("/"+flw_ref+"/" + voId.toString().toLowerCase()));
    }

    public Response runPaypalVoidTransaction(String flw_ref){
        return runTransaction(null, CARD, true, Optional.of("/"+flw_ref+"/paypal-void"));
    }

    public Response runRefundTransaction(String flw_ref, BigDecimal amount){
        return runTransaction(new JSONObject().put("amount", amount).toString(), CARD, true, Optional.of("/"+flw_ref+"/" + refund));
    }

}
