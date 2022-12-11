package com.flutterwave.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
public class Meta {

    private String flightID;
    private String metaname;
    private String metavalue;
    private String name;
    private String tools;
    private String sideNote;
    private  Authorization authorization;
    private String values;
    private String random;
    private PageInfo page_info;

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
