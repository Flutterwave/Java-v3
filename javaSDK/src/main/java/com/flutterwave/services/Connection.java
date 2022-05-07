package com.flutterwave.services;

public interface Connection {

    default String send(String request, String URL){
        return null;
    }

}
