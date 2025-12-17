package com.base.util.image;

import org.junit.Test;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author yhc
 * @create 2024-11-18 15:39
 */
public class AESImageEncryption {

    private static final String ALGORITHM = "AES";

    public static void encrypt(String key, File inputFile, File outputFile) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

        try (FileInputStream fis = new FileInputStream(inputFile);
             FileOutputStream fos = new FileOutputStream(outputFile);
             CipherOutputStream cos = new CipherOutputStream(fos, cipher)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                cos.write(buffer, 0, bytesRead);
            }
        }
    }

    public static void decrypt(String key, File inputFile, File outputFile) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);

        try (FileInputStream fis = new FileInputStream(inputFile);
             FileOutputStream fos = new FileOutputStream(outputFile);
             CipherInputStream cis = new CipherInputStream(fis, cipher)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = cis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }

    /**
     * 加密图片
     */
    @Test
    public void test01() throws Exception {
        String key = "1234567890123456"; // 16 bytes key for AES-128
        File inputFile = new File("C:/Users/admin/Pictures/图片1.png"); // 待加密的图片
        File outputFile = new File("C:/Users/admin/Pictures/图片1.enc"); // 加密后的图片
        // 加密图片
        encrypt(key, inputFile, outputFile);
        System.out.println("加密成功！");
    }

    /**
     * 解密图片
     */
    @Test
    public void test02() throws Exception {
        String key = "1234567890123456"; // 16 bytes key for AES-128
        File outputFile = new File("C:/Users/admin/Pictures/图片1.enc"); // 加密后的图片
        // 解密图片
        decrypt(key, outputFile, new File("C:/Users/admin/Pictures/图片2.png"));
        System.out.println("解密成功！");
    }
}
