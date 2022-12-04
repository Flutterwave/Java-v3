package com.flutterwave.services;

import com.flutterwave.bean.BankAccountRequest;
import com.flutterwave.bean.Response;

import java.util.Optional;

import static com.flutterwave.bean.ChargeTypes.DEBIT_NG_ACCOUNT;
import static com.flutterwave.bean.ChargeTypes.DEBIT_UK_ACCOUNT;

public class BankAccount extends Charge{

    public Response runTransaction(BankAccountRequest bankAccountRequest){
        return runTransaction(bankAccountRequest.toString(),
                bankAccountRequest.getCurrency().equals("NGN")? DEBIT_NG_ACCOUNT: DEBIT_UK_ACCOUNT,
                false, Optional.empty());
    }
}
