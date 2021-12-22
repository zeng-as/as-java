package com.as.encription.util;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class AesBase64Utils {

    public static String generateKey() {
        // 生成KEY ,AES 要求密钥长度为 128
        KeyGenerator keyGenerator = null;
        try {
            keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128);
            SecretKey secretKey = keyGenerator.generateKey();
            byte[] byteKey = secretKey.getEncoded();
            return Base64.getEncoder().encodeToString(byteKey);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String encryptAB(String content, String key) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            Key secretKeySpec = new SecretKeySpec(Base64.getDecoder().decode(key), "AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            byte[] bytes = cipher.doFinal(content.getBytes());
            return Base64.getEncoder().encodeToString(bytes);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String decryptAB(String content, String key) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            Key secretKeySpec = new SecretKeySpec(Base64.getDecoder().decode(key), "AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            byte[] bytes = cipher.doFinal(Base64.getDecoder().decode(content));
            return new String(bytes);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void main(String[] args) {
        String key = generateKey();
        System.out.println("key：" + key);
        String origin = "你好呀，中国";
        System.out.println("原始：" + origin);
        String encrypt = encryptAB(origin, key);
        System.out.println("加密后：" + encrypt);
        String decrypt = decryptAB(encrypt, key);
        System.out.println("解密后：" + decrypt);
    }
}
