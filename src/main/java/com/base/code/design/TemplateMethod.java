package com.base.code.design;

/**
 * 模板方法设计及模式
 *
 * @author yhc
 * @date 2019-07-01 13:51
 */
public class TemplateMethod {

    public static void main(String[] args) {
        Template template = new SubTemplate();
        template.spendTime();
    }

}

abstract class Template {
    /**
     * 计算执行某段代码所需要花费的时间
     */
    public void spendTime() {
        long start = System.currentTimeMillis();
        code();// 不确定的部分
        long end = System.currentTimeMillis();
        System.out.println("花费的时间为：" + (end - start) + "毫秒");
    }

    public abstract void code();
}

class SubTemplate extends Template {

    @Override
    public void code() {
        for (int i = 2; i < 1000; i++) {
            boolean isFlag = true;
            for (int j = 2; j < Math.sqrt(i); j++) {
                if (1 % j == 0) {
                    isFlag = false;
                    break;
                }
            }
            if (isFlag) {
                System.out.println(i);
            }
        }
    }
}