package com.flutterwave.utility;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

/**
 * Handles encrypting payloads sent to F4B
 */
public class PayloadEncryptor {

    private static final String ALGORITHM = "DESede";
    private static final String TRANSFORMATION = "DESede/ECB/PKCS5Padding";

    /**
     *
     * @param data to be encrypted
     * @param encryptionKey String from F4B dashboard; this is set as an ennvironment varibale before processing transactions
     * @return String encrypted response
     */
    public static String TripleDESEncrypt(String data, String encryptionKey) {
        final String defaultString = "";
        if (data == null || encryptionKey == null) return defaultString;
        try {
            final byte[] encryptionKeyBytes = encryptionKey.getBytes();
            final SecretKeySpec secretKey = new SecretKeySpec(encryptionKeyBytes, ALGORITHM);
            final Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            final byte[] dataBytes = data.getBytes();
            byte[] encryptedValue = cipher.doFinal(dataBytes);
            return Base64.getEncoder().encodeToString(encryptedValue);
        } catch (Exception exception) {
            return null;
        }
    }
}
