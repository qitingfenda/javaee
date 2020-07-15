package com.base.code.annotation;

import java.lang.annotation.Annotation;
import java.util.ArrayList;

/**
 * 从jdk5.0开始，Java增加了对元数据(MateDate)的支持，也就是Annotation(注解)
 * Annotation其实就说代码里的特殊标记，这些标记可以在编译，类加载，运行时被读取，
 * 并执行相应的处理，通过使用Annotation，程序员可以在不改变原有逻辑的情况下，
 * 在源文件中嵌入一些补充信息。代码分析工具，开发工具和部署工具可以通过这些补充信息
 * 进行验证或进行部署。
 * <p>
 * Annotation可以像修饰符一样被使用，可用于修饰包，类，构造器，方法，成员变量，参数
 * 局部变量的声明，这些信息被保存在Annotation的"name=value"中
 * <p>
 * JDK内置的三个基本注解
 * -@Override : 限定重写父类方法，该注解只能用于方法
 * -@Deprecated : 用于表示所修饰的元素(类、方法等)已过时
 * -@SuppressWarnings : 抑制编译器警告
 * <p>
 * 跟踪代码依赖性，实现代替配置文件功能
 * <p>
 * 自定义注解:
 * - 定义新的Annotation类型使用@interface关键字
 * - 自定义注解自动继承了 java.lang.annotation.Annotation 接口
 * - Annotation 的成员变量在 Annotation 定义中以无参数方法的形式来声明。
 * 其方法名和返回值定义了该成员的名字和类型。我们称为配置参数。类型只能是
 * 八种基本数据类型、String类型、Class类型、enum类型、Annotation类型、以上所有类型的数组
 * - 可以在定义 Annotation 的成员变量时为其指定初始值，指定成员变量的初始值可以使用default关键字
 * - 如果只有一个参数成员，建议使用参数名为value
 * - 如果定义的注解含有配置参数，那么使用时必须指定参数值，除非它有默认值。格式是"参数名=参数值"，
 * 如果只有一个参数成员，且名为value，可以省略value
 * - 没有成员定义的Annotation 称为标记，包含成员变量的 Annotation 称为元数据 Annotation
 * <p>
 * 注意：自定义注解必须配上注解的信息处理流程（使用反射）才有意义
 * 自定义注解通常都会指定两个元注解：Retention、Target
 * <p>
 * JDK提供的4种元注解(元注解：对现有的注解进行解释说明的注解)
 * Retention:只能用于修饰一个Annotation定义，
 * 用于指定该Annotation的生命周期，@Retention包含一个
 * RetentionPolicy类型的成员变量使用@Rentention时
 * 必须为该value成员变量指定值
 * - RetentionPolicy.SOURCE:在源文件中有效(即源文件保留)，编译器直接丢弃这种策略的注解
 * - RetentionPolicy.CLASS:在class文件中有效(即class保留)，当运行Java程序时，JVM不会保留注解，这是默认值
 * - RetentionPolicy.RUNTIME:在运行时有效(即运行时保留)，当运行Java程序时，JVM会保留注释，程序可以通过反射获该注释。
 * <p>
 * Target:用于修饰Annotation定义，用于指定被修饰的Annotation能用于修饰哪些程序元素。@Target也包含一个名为value的成员变量
 * <p>
 * Documented:表示所修饰的注解在被javadoc解析时，保留下来。
 * - 定义为Documented的注解必须设置Retention值为RUNTIME
 * <p>
 * Inherited:被他修饰的Annotation 将具有继承性，如果某个类使用了被@Inherited
 * 修饰的Annotation，则其子类将自动具有该注解
 * <p>
 * JDK8中注解的新特性：可重复注解，类型注解
 * <p>
 * 可重复注解：
 * 1.在MyAnnotation上声明@Repeatable,成员值为MyAnnotations.class
 * 2.MyAnnotation的Target和Retention和MyAnnotations等元注解相同
 * <p>
 * 类型注解：
 * ElementType.TYPE_PARAMETER表示该注解能写在类型变量的声明语句中(如：泛型声明)
 * ElementType.TYPE_USE表示该注解能写在使用类型的任何语句中
 *
 * @author yhc
 * @date 2019-08-26 10:49
 */
// JDK8之前的写法
//@MyAnnotations({@MyAnnotation(value = "aaa"),@MyAnnotation(value = "bbb")})

@MyAnnotation(value = "aaa")
@MyAnnotation(value = "bbb")
public class AnnotationTest {
    public static void main(String[] args) {
        test01();
    }

    private static void test01() {

        Class<AnnotationTestSub> clazz = AnnotationTestSub.class;

        Annotation[] annotations = clazz.getAnnotations();

        for (Annotation e : annotations) {
            System.out.println(e);
        }
    }
}

class AnnotationTestSub extends AnnotationTest {

}

class Generic<@MyAnnotation T> {

    public void show() throws @MyAnnotation RuntimeException {
        ArrayList<@MyAnnotation String> list = new ArrayList<>();
        int num = (@MyAnnotation int) 10L;
    }

}