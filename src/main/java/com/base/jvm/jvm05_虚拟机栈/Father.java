package com.base.jvm.jvm05_虚拟机栈;

/**
 * @author yhc
 * @create 2020-08-25 10:42
 */
public class Father {

    public void methodA(){
        System.out.println("methodA");
    }

    public static void main(String[] args) {
        Father f = new Sub1();
        f.test(f);
    }

    public void test(Father f) {
        f.methodA();
    }

}
class Sub1 extends Father {
    @Override
    public void methodA() {
        System.out.println("sub1 methodA");
    }
}

class Sub2 extends Father {
    @Override
    public void methodA() {
        System.out.println("sub2 methodA");
    }
}
