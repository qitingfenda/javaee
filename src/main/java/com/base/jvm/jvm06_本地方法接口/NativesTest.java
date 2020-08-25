package com.base.jvm.jvm06_本地方法接口;

/**
 * @author yhc
 * @create 2020-08-25 14:28
 */
public class NativesTest {

    public native void native1(int x);

    native static public long native2();

    native synchronized private float native3(Object o);

    native void native4(int[] arr) throws Exception;

}
