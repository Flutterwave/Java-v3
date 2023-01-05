package com.flutterwave.client;

import com.flutterwave.bean.ChargeTypes;
import org.apache.http.NameValuePair;

import java.util.List;
import java.util.Optional;

import static com.flutterwave.bean.Verb.*;

public class Utility {
    public static String post(String url, String request, ChargeTypes chargeType, List<NameValuePair> nameValuePairs){
        return Optional.ofNullable(Client.runTransaction(
                url,
                request,
                POST,
                chargeType,
                nameValuePairs)).get();
    }

    public static String put(String url, String request, ChargeTypes chargeType, List<NameValuePair> nameValuePairs){
        return Optional.ofNullable(Client.runTransaction(
                url,
                request,
                PUT,
                chargeType,
                nameValuePairs)).get();
    }

    public static String get(String url, ChargeTypes chargeType, List<NameValuePair> nameValuePairs){
        return Optional.ofNullable(Client.runTransaction(
                url,
                null,
                GET,
                chargeType,
                nameValuePairs)).get();
    }

    public static String delete(String url, ChargeTypes chargeType, List<NameValuePair> nameValuePairs){
        return Optional.ofNullable(Client.runTransaction(
                url,
                null,
                DELETE,
                chargeType,
                nameValuePairs)).get();
    }
}
