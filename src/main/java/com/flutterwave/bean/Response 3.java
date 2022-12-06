package com.flutterwave.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.GsonBuilder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Response {

    private String status;
    private String message;
    private Data data;
    private Meta meta;
    private String error_id;
    private String code;

    public static Response toResponse(String value){
        System.out.println(value);
        try{
            return new GsonBuilder().create().
                    fromJson(value, Response.class);
        }catch (Exception e){
            throw new RuntimeException("Error processing request, please contact support!");
        }
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
