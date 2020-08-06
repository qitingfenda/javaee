package com.base.jvm.jvm02_类加载子系统;

/**
 * @author yhc
 * @create 2020-08-04 9:57
 */
public class ClassInitTest01 {

    static class Father {
        public static int A = 1;
        static {
            A = 2;
        }

    }

    static class Son extends Father {
        public static int B = A;
    }

    public static void main(String[] args) {
        System.out.println(Son.B);
    }

}
