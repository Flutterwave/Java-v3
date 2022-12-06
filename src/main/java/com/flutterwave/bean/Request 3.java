package com.flutterwave.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static com.flutterwave.utility.PayloadEncryptor.TripleDESEncrypt;

@Getter
@Setter
@NoArgsConstructor
public class Request {

    public String client;

    public Request(String value){
        System.out.println(value);
        this.client = TripleDESEncrypt(value, System.getProperty("encryptKey"));
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
