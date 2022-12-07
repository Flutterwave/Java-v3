package com.flutterwave.services;

import com.flutterwave.bean.ListResponse;
import com.flutterwave.bean.OTPRequest;
import com.flutterwave.bean.Response;
import org.json.JSONObject;

import java.util.Optional;

import static com.flutterwave.client.Utility.post;
import static com.flutterwave.utility.Properties.getProperty;
import static com.flutterwave.bean.ChargeTypes.OTP;

/**
 * @author Cleopatra Douglas
 */
public class OTP {

    private String ERROR = "Error processing request, please check logs";
    public ListResponse runCreateOTP(OTPRequest otpRequest){
        return Optional.of(post(getProperty("OTP_BASE"), otpRequest.toString(), OTP, null))
                .map(ListResponse::toListResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }

    public Response runValidateOTP(String reference, String otp){
        return Optional.of(post(getProperty("OTP_BASE")+"/"+reference+"/validate",
                        new JSONObject().put("otp", otp).toString(), OTP, null))
                .map(Response::toResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }
}
