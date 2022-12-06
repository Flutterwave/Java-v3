package com.flutterwave.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * @author Cleopatra Douglas
 */
@Getter
@Setter
@NoArgsConstructor
public class CollectionsSubAccountRequest extends  Shared{

    private String split_type;
    private BigDecimal split_value;
    private String business_email;
    private String business_name;
    private String business_contact;
    private String business_contact_mobile;
    private String business_mobile;
    private String country;
//    @Override
//    private List<Meta> meta;

    public CollectionsSubAccountRequest(String account_bank, String account_number, String business_name,
                                        String business_email, String business_contact, String business_contact_mobile, String business_mobile,
                                        String country, Optional<List<Meta>> metaList, String split_type, BigDecimal split_value){
        this.setAccount_bank(account_bank);
        this.setAccount_number(account_number);
        this.business_contact = business_contact;
        this.business_name = business_name;
        this.country = country;
        this.split_type = split_type;
        this.split_value = split_value;
        this.business_email = business_email;
        this.business_mobile = business_mobile;
        this.business_contact_mobile = business_contact_mobile;
        metaList.ifPresent(metas -> this.setMeta((Meta) metas));
    }
}
