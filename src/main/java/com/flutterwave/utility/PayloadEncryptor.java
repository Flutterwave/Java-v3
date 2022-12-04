package com.flutterwave.utility;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class PayloadEncryptor {

    private static final String ALGORITHM = "DESede";
    private static final String TRANSFORMATION = "DESede/ECB/PKCS5Padding";

    public PayloadEncryptor() {}

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
