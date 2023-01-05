package com.flutterwave.utility;

/**
 * Sets environment variables
 * @author cleopatradouglas
 */
public class Environment {

    /**
     * Sets the secret key to be used for transactions
     * @param secretKey String
     */
    public static void setSecretKey(String secretKey){
        System.setProperty("secretKey", secretKey);
    }

    /**
     * Sets the public key to be used for transactions
     * @param publicKey String
     */
    public static void setPublicKey(String publicKey){
        System.setProperty("publicKey", publicKey);
    }

    /**
     * Sets the encrypt key to be used for transactions
     * @param encryptKey String
     */
    public static void setEncryptionKey(String encryptKey){
        System.setProperty("encryptKey", encryptKey);
    }
}
