package com.flutterwave.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * @author Cleopatra Douglas
 */
@Getter
@Setter
@NoArgsConstructor
public class ZambiaMobileMoneyRequestRequest extends MobileMoneyRequest {

    public ZambiaMobileMoneyRequestRequest(String tx_ref, BigDecimal amount, String currency, String voucher, String network,
                                           String email, String phone_number, String fullname, String client_ip,
                                           String device_fingerprint, Optional<Meta> meta){
        this.setTx_ref(tx_ref);
        this.setAmount(amount);
        this.setCurrency(currency);
        this.setVoucher(voucher);
        this.setNetwork(network);
        this.setEmail(email);
        this.setPhone_number(phone_number);
        this.setFullname(fullname);
        this.setClient_ip(client_ip);
        this.setDevice_fingerprint(device_fingerprint);
        meta.ifPresent(this::setMeta);

    }
}
