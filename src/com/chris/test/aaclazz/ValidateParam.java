package com.chris.test.aaclazz;

import java.lang.annotation.*;

//属性的注解
@Target(ElementType.FIELD)   //作用范围为类
@Retention(RetentionPolicy.RUNTIME)     //作用为运行时可获取
public @interface ValidateParam {
    int min() default 0;
    int max() default 100;
    int value() default 20;
}
