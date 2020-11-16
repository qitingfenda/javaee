package com.base.code.other.rsa;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * @author yhc
 * @create 2020-11-04 18:23
 */
public class RSAUtil {

    public static final String SIGN_ALGORITHMS = "SHA256WithRSA";

    public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

    private static Logger LOGGER = LoggerFactory.getLogger(RSAUtil.class);

    /**
     * RSA最大加密明文大小
     */
    private static final int MAX_ENCRYPT_BLOCK = 117;

    /**
     * RSA最大解密密文大小
     */
    private static final int MAX_DECRYPT_BLOCK = 128;


    /**
     * 获取密钥对
     */
    public static KeyPair getKeyPair() throws Exception {
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(1024);
        return generator.generateKeyPair();
    }


    /**
     * 签名
     */
    public static String sign(String content, String privateKey) {
        try {
            PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateKey));
            KeyFactory keyf = KeyFactory.getInstance("RSA");
            PrivateKey priKey = keyf.generatePrivate(priPKCS8);
            Signature signature = Signature.getInstance(SIGN_ALGORITHMS);
            signature.initSign(priKey);
            signature.update(content.getBytes(DEFAULT_CHARSET));
            byte[] signed = signature.sign();
            return Base64.getEncoder().encodeToString(signed);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 验签
     */
    public static boolean verify(String content, String sign, String publicKey) {
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            byte[] encodedKey = Base64.getDecoder().decode(publicKey);
            PublicKey pubKey = keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));

            Signature signature = Signature.getInstance(SIGN_ALGORITHMS);

            signature.initVerify(pubKey);
            signature.update(content.getBytes(DEFAULT_CHARSET));

            return signature.verify(Base64.getDecoder().decode(sign));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    /**
     * 获取公钥
     */
    public static PublicKey getPublicKey(String key) throws Exception {
        byte[] keyBytes = Base64.getDecoder().decode(key);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePublic(keySpec);
    }

    /**
     * 获取密钥
     */
    public static PrivateKey getPrivateKey(String key) throws Exception {
        byte[] keyBytes = Base64.getDecoder().decode(key);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePrivate(keySpec);
    }


    /**
     * 公钥分段加密
     */
    public static String publicEncrypt(String content, String publicKeyStr) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(1, getPublicKey(publicKeyStr));
        byte[] bytes = content.getBytes(DEFAULT_CHARSET);
        // 对数据分段加密
        byte[] sectionEncrypt = sectionEncrypt(cipher, bytes, MAX_ENCRYPT_BLOCK);
        return Base64.getEncoder().encodeToString(sectionEncrypt);
    }


    /**
     * 私钥分段加密
     */
    public static String privateEncrpyt(String content, String privateKeyStr) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(1, getPrivateKey(privateKeyStr));
        byte[] bytes = content.getBytes(DEFAULT_CHARSET);
        // 对数据分段加密
        byte[] encryptedData = sectionEncrypt(cipher, bytes, MAX_ENCRYPT_BLOCK);
        return Base64.getEncoder().encodeToString(encryptedData);
    }

    private static byte[] sectionEncrypt(Cipher cipher, byte[] bytes, int maxEncryptBlock) {
        byte[] cache;
        int inputLen = bytes.length;
        int offSet = 0;
        int i = 0;
        byte[] result = new byte[0];
        ByteArrayOutputStream out = null;
        try {
            out = new ByteArrayOutputStream();
            while (inputLen - offSet > 0) {
                if (inputLen - offSet > maxEncryptBlock) {
                    cache = cipher.doFinal(bytes, offSet, maxEncryptBlock);
                } else {
                    cache = cipher.doFinal(bytes, offSet, inputLen - offSet);
                }
                out.write(cache, 0, cache.length);
                i++;
                offSet = i * maxEncryptBlock;
            }
            result = out.toByteArray();
            out.close();
        } catch (Exception e) {
            LOGGER.error("RSA加密/解密失败 exception:{}", e);
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }


    /**
     * 私钥分段解密
     */
    public static String privateDecrypt(String content, String privateKeyStr) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(2, getPrivateKey(privateKeyStr));
        byte[] bytes = Base64.getDecoder().decode(content);
        // 对数据分段解密
        byte[] decryptedData = sectionEncrypt(cipher, bytes, MAX_DECRYPT_BLOCK);
        return new String(decryptedData);
    }


    /**
     * 公钥分段解密
     */
    public static String publicDecrypt(String content, String publicKeyStr) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(2, getPublicKey(publicKeyStr));
        byte[] bytes = Base64.getDecoder().decode(content);
        // 对数据分段解密
        byte[] decryptedData = sectionEncrypt(cipher, bytes, MAX_DECRYPT_BLOCK);
        return new String(decryptedData);
    }


    @Test
    public void test01() throws Exception {
        // 密文
        String str = "Tzu1pofB9oPO7/wNrcUYo85/hsqtVJLNkW3aE18HdLYFGi7Cigw6ZGaHC95rembbp1tw8StO7bVJ+r3HyfDWf+wgBlLluCrWKmZdcA3JJ0OAgrjbxII+8a4uhl8icrazURm624dPfZ+W5PychVdMFy2IXaW2YEe6yHlh8FFQxYBuCWBEHf9OL82ASIHAHBJZmNia888vWk3V+hJPUG1H6ng+1Ck2rxRYML7WqnO5ke5B30qVdAd9835PqN2zw2w9f9P7Be+ndlouJ9TLS2HtSNz38Whuni69jgIOuq8iZqGpGqpxX0gDDcbySrl6T0TY5xdu6iA2VFoEBoY79oEysQ==";
        //私钥844
        String privateKey =
                "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAIJoafn5ir2juTGYNLbPAhEQgSRy" +
                        "kpvHji49P89fbZc6ODOQy9sIRqa7srJq02GSutIfoTXiXUXvf1bO1d98n84JdSaAXh6Ax53IYIDz" +
                        "KZlZvPKHCdlzLBryZ7xLauNveCQIPpUWrwFI8nH29oy+VHt5nF7U7mWWVpXq0TpKU1jtAgMBAAEC" +
                        "gYBOzKsk+s4EM5dnSXKo+ENmblOq43SFnzrh4+7X7vD4zZxCRH96NfEDNS4Qs45RSmmLKMOwHL2B" +
                        "0etfWBJSPisNZomhOBgTSfvHDSIFNbvVFqQBH5zEtxIB3bPrkW5X6EDF2BYCatC70Al21kmzHr2d" +
                        "BaL/c2p/4ueTdna/zKSKwQJBAMZLvFeyLi9jiIXXUzv7AkxF4SICtOOL56mKMkVlAXOWQgQe9FVs" +
                        "O8lTTK6GqqLrYe5cqgTiQqcLCP8/5n33oF0CQQCoW0ospTg8JEqStTmwemF8HfgxLU6YGj5kegD2" +
                        "Fq6HfCTq/z59THohbq6l+yoSxO3mjZb+7Zv1zu6oDR7YXFHRAkB66dEaDtFAAJNMWxc107Yt7xbI" +
                        "zSKw9TSoy4ezqhNHQXk0MrfDB27bsS2T9NdqWzr91CRzGIi2IEn4ZfSKWmblAkB2S1bOEfV2hMWF" +
                        "WiND9mnDDUfUPhKIW4BVl0hPodZWSouiN2DQJ8l07lF3PQjuEUNcCUb8rzYzvIgCut1eh1fRAkEA" +
                        "qBOEqBuRq9W7vrBlHbqEk1EXu2MfeRLZWljZn6uoyedJCdSh+6neUUvqHDGi3DNdss/ByWHI9e+9" +
                        "zOXTURmMaQ==";
        String s1 = privateDecrypt(str, privateKey);
        System.out.println("解密后：" + s1);
    }

    public static void main(String[] args) throws Exception {
        String content = "asdhaoddddddaosdjosadosaudosaudaosdusadadsadsadsadasdasdasdasdsadsadsadasdasdasdsadasdsadasdsadsadadsadsadadiugtiutujjjkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkka";
        // 公钥216
        String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCCaGn5+Yq9o7kxmDS2zwIREIEkcpKbx44uPT/PX22XOjgzkMvbCEamu7KyatNhkrrSH6E14l1F739WztXffJ/OCXUmgF4egMedyGCA8ymZWbzyhwnZcywa8me8S2rjb3gkCD6VFq8BSPJx9vaMvlR7eZxe1O5lllaV6tE6SlNY7QIDAQAB";
        //私钥844
        String privateKey =
                "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAIJoafn5ir2juTGYNLbPAhEQgSRy" +
                        "kpvHji49P89fbZc6ODOQy9sIRqa7srJq02GSutIfoTXiXUXvf1bO1d98n84JdSaAXh6Ax53IYIDz" +
                        "KZlZvPKHCdlzLBryZ7xLauNveCQIPpUWrwFI8nH29oy+VHt5nF7U7mWWVpXq0TpKU1jtAgMBAAEC" +
                        "gYBOzKsk+s4EM5dnSXKo+ENmblOq43SFnzrh4+7X7vD4zZxCRH96NfEDNS4Qs45RSmmLKMOwHL2B" +
                        "0etfWBJSPisNZomhOBgTSfvHDSIFNbvVFqQBH5zEtxIB3bPrkW5X6EDF2BYCatC70Al21kmzHr2d" +
                        "BaL/c2p/4ueTdna/zKSKwQJBAMZLvFeyLi9jiIXXUzv7AkxF4SICtOOL56mKMkVlAXOWQgQe9FVs" +
                        "O8lTTK6GqqLrYe5cqgTiQqcLCP8/5n33oF0CQQCoW0ospTg8JEqStTmwemF8HfgxLU6YGj5kegD2" +
                        "Fq6HfCTq/z59THohbq6l+yoSxO3mjZb+7Zv1zu6oDR7YXFHRAkB66dEaDtFAAJNMWxc107Yt7xbI" +
                        "zSKw9TSoy4ezqhNHQXk0MrfDB27bsS2T9NdqWzr91CRzGIi2IEn4ZfSKWmblAkB2S1bOEfV2hMWF" +
                        "WiND9mnDDUfUPhKIW4BVl0hPodZWSouiN2DQJ8l07lF3PQjuEUNcCUb8rzYzvIgCut1eh1fRAkEA" +
                        "qBOEqBuRq9W7vrBlHbqEk1EXu2MfeRLZWljZn6uoyedJCdSh+6neUUvqHDGi3DNdss/ByWHI9e+9" +
                        "zOXTURmMaQ==";


        String s = publicEncrypt(content, publicKey);
        System.out.println("公钥加密后" + s);


        String s1 = privateDecrypt(s, privateKey);
        System.out.println("解密后" + s1);

/*
       //公钥加密-->私钥签名-->公钥验签-->私钥解密
       String s = publicEncrpyt(content, publicKey);
        System.out.println("公钥加密后"+s);

        //签名     Authorization
        String sign = sign(s, privateKey);
        System.out.println("私钥签名后："+sign);

        //验签
        boolean verify = verify(s, sign, publicKey);
        System.out.println("用公钥验签后"+verify);

        String s1 = privateDecrypt(s, privateKey);
        System.out.println("解密后"+s1 );
*/

        /*String s = privateEncrpyt(content, privateKey);
        System.out.println("公钥加密后" + s);

        String sign = sign(s, privateKey);
        System.out.println("私钥签名后：" + sign);

        boolean verify = verify(s, sign, publicKey);
        System.out.println("用公钥验签后" + verify);

        String s1 = publicDecrypt(s, publicKey);
        System.out.println("解密后" + s1);*/
    }

}
