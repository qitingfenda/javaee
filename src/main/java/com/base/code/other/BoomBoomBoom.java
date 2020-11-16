package com.base.code.other;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;

/**
 * @author yhc
 * @date 2019-07-11 16:50
 */
public class BoomBoomBoom {

    public static void main(String[] args) throws AWTException {
        // 定义要发送的话
        String sentence = "从前有座山,山里有座庙,庙里有个老和尚和小和尚,老和尚对小和尚说：";
        // 创建Robot对象

        Robot robot = new Robot();
        // 延迟三秒，主要是为了预留出打开窗口的时间，括号内的单位为毫秒
        robot.delay(3000);
        Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
        // 字符串根据,分割

        String[] authors = sentence.split("[,]");
        // 循环次数
        int value = 50;
        //循环次数从前有座山
        for (int j = 0; j < value; j++) {
            for (String str : authors) {
                Transferable tText = new StringSelection(str);
                clip.setContents(tText, null);
                // 以下两行按下了ctrl+v，完成粘贴功能
                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_V);
                //释放ctrl按键，像ctrl，退格键，删除键这样的功能性按键，在按下后一定要释放，不然会出问题。crtl如果按住没有释放，在按其他字母按键是，敲出来的回事ctrl的快捷键。
                robot.keyRelease(KeyEvent.VK_CONTROL);
                //延迟一秒再发送，不然会一次性全发布出去，因为电脑的处理速度很快，每次粘贴发送的速度几乎是一瞬间，所以给人的感觉就是一次性发送了全部。这个时间可以自己改，想几秒发送一条都可以
                robot.delay(500);
                // 回车
                robot.keyPress(KeyEvent.VK_ENTER);
            }
        }
    }
}