package com.flutterwave.client;

import java.util.Optional;

import static com.flutterwave.bean.Verb.*;

public class Utility {

    public static String post(String url, String request){
        return Optional.ofNullable(Client.runTransaction(
                url,
                request,
                POST)).get();
    }

    public static String put(String url, String request){
        return Optional.ofNullable(Client.runTransaction(
                url,
                request,
                PUT)).get();
    }

    public static String get(String url){
        return Optional.ofNullable(Client.runTransaction(
                url,
                null,
                GET)).get();
    }

    public static String delete(String url){
        return Optional.ofNullable(Client.runTransaction(
                url,
                null,
                DELETE)).get();
    }
}
