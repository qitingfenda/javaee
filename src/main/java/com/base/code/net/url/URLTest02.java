package com.base.code.net.url;

import org.junit.Test;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author yhc
 * @date 2019-12-24 14:31
 */
public class URLTest02 {

    @Test
    public void test01() {
        HttpURLConnection urlConnection = null;
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            URL url = new URL("http://172.17.0.55/img0/M00/18/B6/ChpbMF2MSGSAQW_MAAAnYCrMG4A535.jpg");
            urlConnection = (HttpURLConnection) url.openConnection();
            // 获取流
            is = urlConnection.getInputStream();
            fos = new FileOutputStream(new File("C:\\Users\\七听芬达\\Pictures\\head3.jpg"));
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (is != null)
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (urlConnection != null)
                urlConnection.disconnect();
        }
    }

}
