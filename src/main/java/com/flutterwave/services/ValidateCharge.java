package com.flutterwave.services;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flutterwave.bean.ChargeTypes;
import com.flutterwave.bean.Response;
import com.flutterwave.client.Client;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Optional;

import static com.flutterwave.bean.ChargeTypes.VALIDATE_CHARGE;
import static com.flutterwave.bean.Verb.POST;
import static com.flutterwave.utility.Properties.getProperty;

@Getter
@Setter
@NoArgsConstructor
public class ValidateCharge {
    private String otp;
    private String flw_ref;
    private String type;

    private String ERROR = "Error processing request, please check logs";

    public ValidateCharge(String otp, String flw_ref, Optional<ChargeTypes> type){
        this.otp = otp;
        this.flw_ref = flw_ref;
        type.ifPresent(chargeTypes -> this.type = String.valueOf(chargeTypes));
    }
    public Response runTransaction(){
        return Optional.ofNullable(Client.runTransaction(
                getProperty("VALIDATE_CHARGE_ENDPOINT"),
                this.toString(),
                POST, VALIDATE_CHARGE, null))
                .map(Response::toResponse).orElseThrow(() -> new RuntimeException(ERROR));
    }

    @Override
    public String toString() {

        String value = null;
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        try {
            value = objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return value;

    }
}
