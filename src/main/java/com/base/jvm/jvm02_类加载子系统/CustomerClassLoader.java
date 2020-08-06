package com.base.jvm.jvm02_类加载子系统;

import java.io.FileNotFoundException;

/**
 * @author yhc
 * @create 2020-08-05 9:18
 */
public class CustomerClassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] result = getClassFromCustomerPath(name);
            if (result == null) {
                throw new FileNotFoundException();
            } else {
                return defineClass(name, result, 0, result.length);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        throw new ClassNotFoundException(name);
    }

    private byte[] getClassFromCustomerPath(String name) {
        // 自定义路径中加载指定类
        // 如果指定路径的字节码文件进行了加密，则需要在此方法中进行解密操作。
        return null;
    }
}
