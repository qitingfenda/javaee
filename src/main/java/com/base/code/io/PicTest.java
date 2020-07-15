package com.base.code.io;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 图片加密解密
 *
 * @author yhc
 * @date 2019-11-19 16:52
 */
public class PicTest {

    /**
     * 加密
     */
    @Test
    public void test01() {
        String target = "C:\\Users\\七听芬达\\Pictures\\head.jpg";
        String dest = "C:\\Users\\七听芬达\\Pictures\\head1.jpg";
        copyFile(target, dest);
    }

    /**
     * 解密
     */
    @Test
    public void test02() {
        String target = "C:\\Users\\七听芬达\\Pictures\\head1.jpg";
        String dest = "C:\\Users\\七听芬达\\Pictures\\head2.jpg";
        copyFile(target, dest);
    }

    private void copyFile(String target, String dest) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File file = new File(target);
            File file1 = new File(dest);
            fis = new FileInputStream(file);
            fos = new FileOutputStream(file1);
            byte[] buffer = new byte[10];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                for (int i = 0; i < len; i++) {
                    buffer[i] = (byte) (buffer[i] ^ 5);
                }
                fos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
