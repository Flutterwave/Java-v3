package com.flutterwave.services;

import com.flutterwave.bean.BanKTransferRequest;
import com.flutterwave.bean.Response;

import java.util.Optional;

import static com.flutterwave.bean.ChargeTypes.BANK_TRANSFER;

/**
 * @author cleopatradouglas
 */
public class BanKTransfer extends Charge{
    /**
     * Handles bank transfer requests
     * @param banKTransferRequest bean
     * @return Response
     */
    public Response runTransaction(BanKTransferRequest banKTransferRequest){
        return runTransaction(banKTransferRequest.toString(), BANK_TRANSFER, false, Optional.empty());
    }
}
