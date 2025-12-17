package com.base.util;

import java.io.IOException;

/**
 * @author yhc
 * @create 2024-01-25 9:26
 */
public class WinStart {
    public static void main(String[] args) {
        try {
            // QQ的可执行文件名称为"QQ.exe"，根据自己电脑上的情况进行修改
            String qqPath = "C:\\Program Files (x86)\\Tencent\\QQ\\Bin\\QQScLauncher.exe";
            Process process = Runtime.getRuntime().exec(qqPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
