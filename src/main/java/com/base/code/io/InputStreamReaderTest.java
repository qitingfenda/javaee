package com.base.code.io;

import org.junit.Test;

import java.io.*;

/**
 * 处理流之二：转换流的使用
 * 1.转换流：属于字符流
 * InputStreamReader：将一个字节的输入流转换为字符的输入流
 * OutputStreamWriter：将一个字符的输出流转换位字节的输出流
 * <p>
 * 2.作用：提供字节流与字符流之间的转换
 * <p>
 * 3.解码：字节、字节数组--->字符数组、字符串。编码：字符数组、字符串--->字节、字符数组
 * <p>
 * 4.字符集
 * ASCII：美国标准信息交换码，用一个字节的7位可以表示。
 * ISO8859-1：拉丁码表。欧洲码表，用一个字节的8位可以表示
 * GB2312：中国的中文编码表。最多两个字节编码所有字符
 * GBK：中国的中文编码表升级，融合了更多的中文文字符号。最多两个字节编码。
 * （根据字节第一位是0还是1进行节码：0表示一个字节代表一个字符，1表示两个字节代表一个字符）
 * Unicode：国际标准吗，融合了目前人类使用的所有字符。为每个字符分配唯一的字符码。所有的文字都用两个字节来表示。
 * UTF-8：变长的编码方式，可以用1-4个字节老表示一个字符。
 * 0-7F 使用一个字节存储            0XXXXXXX
 * 80-7FF 使用两个字节存储          110XXXXX 10XXXXXX
 * 800-FFFF 使用三个字节存储        1110XXXX 10XXXXXX 10XXXXXX
 * 10000-10FFFF 使用四个字节存储    11110XXX 10XXXXXX 10XXXXXX 10XXXXXX
 *
 * @author yhc
 * @date 2019-11-20 13:36
 */
public class InputStreamReaderTest {

    @Test
    public void test01() {
        String target = "C:\\Users\\七听芬达\\IdeaProjects\\javaee\\src\\main\\java\\com\\base\\code\\io\\hello.txt";
        String dest = "C:\\Users\\七听芬达\\IdeaProjects\\javaee\\src\\main\\java\\com\\base\\code\\io\\hello1.txt";
        InputStreamReader isr = null;
        OutputStreamWriter osr = null;
        try {
            // 使用系统默认的字符集
            isr = new InputStreamReader(new FileInputStream(target));
            // 使用指定的字符集，具体使用哪个字符集，取决于文件保存时使用的字符集
//            isr = new InputStreamReader(new FileInputStream(target), "UTF-8");
            // 使用不同的字符集可能会乱码
//            isr = new InputStreamReader(new FileInputStream(target), "GBK");
//            osr = new OutputStreamWriter(new FileOutputStream(dest));
            osr = new OutputStreamWriter(new FileOutputStream(dest), "UTF-8");
//            osr = new OutputStreamWriter(new FileOutputStream(dest), "GBK");
            char[] buffer = new char[10];
            int len;
            while ((len = isr.read(buffer)) != -1) {
                System.out.print(new String(buffer, 0, len));
                osr.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (isr != null)
                    isr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (osr != null)
                    osr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
