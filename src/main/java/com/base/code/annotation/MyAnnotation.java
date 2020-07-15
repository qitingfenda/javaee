package com.base.code.annotation;


import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

/**
 * @author yhc
 * @date 2019-08-26 16:20
 */
@Repeatable(MyAnnotations.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, TYPE_PARAMETER, TYPE_USE})
@Documented
//@Inherited
public @interface MyAnnotation {
    String value() default "hello";
}
