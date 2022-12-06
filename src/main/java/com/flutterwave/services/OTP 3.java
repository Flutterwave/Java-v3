package com.flutterwave.services;

import com.flutterwave.bean.ListResponse;
import com.flutterwave.bean.OTPRequest;
import com.flutterwave.bean.Response;
import org.json.JSONObject;

import java.util.Optional;

import static com.flutterwave.client.Utility.post;
import static com.flutterwave.utility.Properties.getProperty;

/**
 * @author Cleopatra Douglas
 */
public class OTP {

    public ListResponse runCreateOTP(OTPRequest otpRequest){
        return Optional.of(post(getProperty("OTP_BASE"), otpRequest.toString()))
                .map(ListResponse::toListResponse).orElseThrow();
    }

    public Response runValidateOTP(String reference, String otp){
        return Optional.of(post(getProperty("OTP_BASE")+"/"+reference+"/validate",
                        new JSONObject().put("otp", otp).toString()))
                .map(Response::toResponse).orElseThrow();
    }
}
