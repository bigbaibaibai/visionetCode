package com.visionet.common.utils;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public enum EncryptUtils {
    i;
    private final String DES_ALGORITHM = "DES";

    /**
     * @param plainData Original string
     * @param secretKey Encrypt key
     * @return The string which encrypted
     * @throws Exception
     */
    public String encrypt(String plainData, String secretKey) throws Exception {

        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance(DES_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, generateKey(secretKey));
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("NoSuchAlgorithmException", e);
        } catch (NoSuchPaddingException e) {
            throw new Exception("NoSuchPaddingException", e);
        } catch (InvalidKeyException e) {
            throw new Exception("InvalidKeyException", e);
        }

        try {
            byte[] buf = cipher.doFinal(plainData.getBytes());
            return BASE64Util.i.encode(buf);
        } catch (IllegalBlockSizeException e) {
            throw new Exception("IllegalBlockSizeException", e);
        } catch (BadPaddingException e) {
            throw new Exception("BadPaddingException", e);
        }
    }

    /**
     * @param secretKey
     * @return
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     * @throws InvalidKeyException
     */
    private Key generateKey(String secretKey)
            throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException {
        DESKeySpec keySpec = new DESKeySpec(secretKey.getBytes());
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES_ALGORITHM);
        keyFactory.generateSecret(keySpec);
        return keyFactory.generateSecret(keySpec);
    }
}
