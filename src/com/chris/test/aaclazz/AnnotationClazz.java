package com.chris.test.aaclazz;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//类名的注解
@Target(ElementType.TYPE)   //作用范围为类
@Retention(RetentionPolicy.RUNTIME)//作用为运行时可获取
public @interface AnnotationClazz{
    String value();
}
