package com.base.code.reflection;

import com.base.code.entity.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.ArrayList;

/**
 * @author yhc
 * @date 2019-12-26 10:21
 */
public class ReflectionTest02 {

    /**
     * 获取当前运行时类声明的注解
     */
    @Test
    public void classAnnotationTest() {
        Class<Person> clazz = Person.class;
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }

    /**
     * 获取当前运行时类的包
     */
    @Test
    public void packageTest() {
        Class<String> clazz = String.class;
        Package aPackage = clazz.getPackage();
        System.out.println(aPackage);
    }

    /**
     * 获取当前运行时类实现的接口
     */
    @Test
    public void interfaceTest() {
        Class<String> clazz = String.class;
        Class<?>[] interfaces = clazz.getInterfaces();
        for (Class<?> e : interfaces) {
            System.out.println(e);
        }
    }

    /**
     * 获取当前运行时类带泛型的父类
     */
    @Test
    public void genericSuperTest() {
        Class<ArrayList> clazz = ArrayList.class;
        Type genericSuperclass = clazz.getGenericSuperclass();
        // 强转
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        // 获取泛型类型
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        for (Type actualTypeArgument : actualTypeArguments) {
            System.out.println(actualTypeArgument.getTypeName());
        }
        System.out.println(genericSuperclass);
    }

    /**
     * 获取当前运行时类的父类
     */
    @Test
    public void superTest() {
        Class<Person> clazz = Person.class;
        Class<? super Person> superclass = clazz.getSuperclass();
        System.out.println(superclass);
    }

    /**
     * 获取当前运行时类的构造器
     */
    @Test
    public void constructorsTest() {
        Class<Person> clazz = Person.class;
        System.out.println("------------------------------------constructors------------------------------------");
        // getConstructors():获取当前运行时类中，声明为public的构造器
        Constructor<?>[] constructors = clazz.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println("|       " + constructor);
        }
        System.out.println("------------------------------------constructors------------------------------------");
        System.out.println();
        System.out.println();
        System.out.println("------------------------------------constructors------------------------------------");
        // getDeclaredConstructors:获取当前运行时类中，声明的所有构造器
        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println("|       " + declaredConstructor);
        }
        System.out.println("------------------------------------constructors------------------------------------");
    }

    /**
     * 获取当前运行时类的方法结构
     */
    @Test
    public void methodTest() {
        Class<Person> clazz = Person.class;
        // getMethods():获取当前运行时类及其所有父类中声明为public权限的方法
        Method[] methods = clazz.getMethods();
        System.out.println("------------------------------------method------------------------------------");
        for (Method method : methods) {
            System.out.println("|       " + method);
        }
        System.out.println("------------------------------------method------------------------------------");
        System.out.println();
        System.out.println();
        System.out.println("------------------------------------declaredMethod------------------------------------");
        // getDeclaredMethods():获取当前运行时类中声明的所有方法。（不包含父类中声明的方法）
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println("|-----方法名----：" + declaredMethod);
            // 获取方法声明的注解
            Annotation[] annotations = declaredMethod.getAnnotations();
            for (Annotation annotation : annotations) {
                System.out.println("--注解--   " + annotation);
            }
            // 权限修饰符
            System.out.println("--权限修饰符--   " + declaredMethod.getModifiers() + " : " + Modifier.toString(declaredMethod.getModifiers()));
            // 返回值类型
            System.out.println("--返回值类型--   " + declaredMethod.getReturnType());
            // 方法名
            System.out.println("--方法名--   " + declaredMethod.getName());
            // 形参列表
            Parameter[] parameters = declaredMethod.getParameters();
            for (Parameter parameter : parameters) {
                System.out.println("--形参列表--   " + parameter);
            }
            // 抛出的异常
            Class<?>[] exceptionTypes = declaredMethod.getExceptionTypes();
            for (Class<?> exceptionType : exceptionTypes) {
                System.out.println("--抛出的异常--   " + exceptionType);
            }

            System.out.println();

        }
        System.out.println("------------------------------------declaredMethod------------------------------------");
    }

    /**
     * 获取当前运行时类的属性结构
     */
    @Test
    public void fieldTest() {
        Class<Person> clazz = Person.class;
        // getFields():获取当前运行时类及其父类中声明为public访问权限的属性
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println(field);
            System.out.println("------------------------------------------------------------------------");
            System.out.println("------------------------------------------------------------------------");
            System.out.println("------------------------------------------------------------------------");
        }
        // getDeclaredFields():获取当前运行时类中声明的所有属性。（不包含父类中声明的属性）
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("============   " + declaredField + "   ============");
            // 1.权限修饰符
            System.out.println("权限修饰符:");
            int modifiers = declaredField.getModifiers();
            System.out.println(modifiers);
            System.out.println(Modifier.toString(modifiers));
            // 2.数据类型
            System.out.println("数据类型:");
            Class<?> type = declaredField.getType();
            System.out.println(type.getName());
            //3.变量名
            System.out.println("变量名:");
            String name = declaredField.getName();
            System.out.println(name);
        }
    }

}
