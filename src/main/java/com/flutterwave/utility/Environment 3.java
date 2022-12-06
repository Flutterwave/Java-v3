package com.flutterwave.utility;

public class Environment {

    public static void setSecretKey(String secretKey){
        System.setProperty("secretKey", secretKey);
    }
    public static void setPublicKey(String publicKey){
        System.setProperty("publicKey", publicKey);
    }
    public static void setEncryptionKey(String secretKey){
        System.setProperty("encryptKey", secretKey);
    }
}
