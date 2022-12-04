package com.flutterwave.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Cleopatra Douglas
 */
@Getter
@Setter
@NoArgsConstructor
public class UpdateTokenRequest extends Shared{

    public  UpdateTokenRequest(String email,
                               String full_name,
                               String phone_number){
        this.setEmail(email);
        this.setFullname(full_name);
        this.setPhone_number(phone_number);

    }
}
