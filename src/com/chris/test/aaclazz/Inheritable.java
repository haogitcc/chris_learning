package com.chris.test.aaclazz;

import java.lang.annotation.*;

/**
 * 自定义的Annotation。
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@interface Inheritable {
}
