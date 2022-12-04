package com.flutterwave.services;

import com.flutterwave.bean.BanKTransferRequest;
import com.flutterwave.bean.Response;

import java.util.Optional;

import static com.flutterwave.bean.ChargeTypes.BANK_TRANSFER;

public class BanKTransfer extends Charge{
    public Response runTransaction(BanKTransferRequest banKTransferRequest){
        return runTransaction(banKTransferRequest.toString(), BANK_TRANSFER, false, Optional.empty());
    }
}
