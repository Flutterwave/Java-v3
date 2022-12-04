package com.flutterwave.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

}
