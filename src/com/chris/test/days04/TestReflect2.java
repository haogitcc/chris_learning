package com.chris.test.days04;

import com.chris.test.aaclazz.AnnotationClazz;
import com.chris.test.aaclazz.ReflectionClazz;
import com.chris.test.aaclazz.ValidateParam;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

public class TestReflect2 {

    public static void main(String[] args) {

        try {
//            testObj();
            testArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void testArray() throws Exception {

        Class<?> cls = Class.forName("java.lang.String");
        Object array = Array.newInstance(cls, 25);
        //往数组里添加内容
        Array.set(array, 0, "Scalas");
        Array.set(array, 1, "Java");
        Array.set(array, 2, "Groovy");
        Array.set(array, 3, "Scala");
        Array.set(array, 4, "Clojure");
        //获取某一项的内容
        System.out.println(Array.get(array, 0));
        System.out.println(Array.get(array, 1));
        System.out.println(Array.get(array, 2));
        System.out.println(Array.get(array, 3));
        System.out.println(Array.get(array, 4));
    }

    private static void testObj() throws Exception {
        boolean show = true;
        System.out.println("创建对象");
        ReflectionClazz reflectionClazz = new ReflectionClazz();
        reflectionClazz.getParam1();
        System.out.println();

        //获取class的方法
        System.out.println("加载类");
        // 1. 对象.getClass
//        ReflectionClazz obj =  new ReflectionClazz();
//        Class clazz = obj.getClass();

        // 2. 类名.class
//        Class clazz = ReflectionClazz.class;

        //3. Class.forName("全路径")
        Class clazz = Class.forName("com.chris.test.aaclazz.ReflectionClazz");
        System.out.println();

        //region interface
        System.out.println("获取所有接口: ");
        Class[] interfaces = clazz.getInterfaces();
        System.out.println("#### Interfaces " + interfaces.length);
        for (Class inf : interfaces) {
            System.out.println("inf-> " + inf);
        }
        System.out.println();
        Type[] genericInterfaces = clazz.getGenericInterfaces();
        System.out.println("#### GenericInterfaces " + genericInterfaces.length);
        for (Type type : genericInterfaces) {
            System.out.println("type-> " + type);
        }
        System.out.println();
        AnnotatedType[] annotatedTypes = clazz.getAnnotatedInterfaces();
        System.out.println("#### annotatedTypes " + annotatedTypes.length);
        for (AnnotatedType annotatedType : annotatedTypes) {
            System.out.println("annotatedType-> " + annotatedType);
        }
        System.out.println();
        //endregion interface

        //region classes
        System.out.println("获取所有类: ");
        Class[] declaredClasses = clazz.getDeclaredClasses();
        System.out.println("#### DeclaredClasses " + declaredClasses.length);
        for (Class clz : declaredClasses) {
            System.out.println("Class-> " + clz);
        }
        System.out.println();
        Class[] clazzes = clazz.getClasses();
        System.out.println("#### Classes " + clazzes.length);
        for (Class clz : clazzes) {
            System.out.println("Class-> " + clz);
        }
        System.out.println();
        //endregion classes

        //region methods
        //获取类的方法、属性等
        System.out.println("获取所有方法：");
        Method[] methods = clazz.getMethods();
        System.out.println("#### Methods " + methods.length);
        for (Method m : methods) {
            System.out.println("Method-> " + m);
        }
        System.out.println();
        Method[] declaredMethods = clazz.getDeclaredMethods();
        System.out.println("#### DeclaredMethods " + declaredMethods.length);
        for (Method m : declaredMethods) {
            System.out.println("Method-> " + m);
        }
        System.out.println();
        //endregion methods

        //region fields
        System.out.println("获取所有属性：");
        Field[] fields = clazz.getFields();
        System.out.println("#### Fields " + fields.length);
        for (Field f : fields) {
            System.out.println("Field-> " + f);
        }
        System.out.println();
        Field[] declaredFields = clazz.getDeclaredFields();
        System.out.println("#### DeclaredFields " + declaredFields.length);
        for (Field f : declaredFields) {
            System.out.println("Field-> " + f);
        }
        System.out.println();
        //endregion fields

        //region constructors
        System.out.println("获取所有构造函数：");
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        System.out.println("#### DeclaredConstructors " + declaredConstructors.length);
        for (Constructor c : declaredConstructors) {
            System.out.println("Constructor-> " + c);
        }
        System.out.println();
        Constructor[] constructors = clazz.getConstructors();
        System.out.println("#### Constructors " + constructors.length);
        for (Constructor c : constructors) {
            System.out.println("Constructor-> " + c);
        }
        System.out.println();
        //endregion constructors

        //region annotations
        System.out.println("获取所有注解：");
        Annotation[] declaredAnnotations = clazz.getDeclaredAnnotations();
        System.out.println("#### DeclaredAnnotations " + declaredAnnotations.length);
        for (Annotation a : declaredAnnotations) {
            System.out.println("Annotations-> " + a);
        }
        System.out.println();
        Annotation[] annotations = clazz.getAnnotations();
        System.out.println("#### Annotations " + annotations.length);
        for (Annotation a : annotations) {
            System.out.println("Annotations-> " + a);
        }
        System.out.println();
        //endregion annotations

        //调用指定方法
        //region newInstance
        System.out.println("通过clazz创建对象");
        ReflectionClazz clazzObj = (ReflectionClazz) clazz.newInstance();
        clazzObj.getParam1();
        System.out.println();

        //获取构造方法并创建对象
        System.out.println("获取构造方法并创建对象");
        Constructor c = clazz.getConstructor();
        ReflectionClazz obj = (ReflectionClazz) c.newInstance();
        obj.getParam1();
        System.out.println();

        //获取带参数的构造方法并创建对象
        System.out.println("获取带参数的构造方法并创建对象");
        Constructor c2 = clazz.getConstructor(int.class, String.class, int.class, String.class);
        ReflectionClazz obj2 = (ReflectionClazz) c2.newInstance(1, "1st", 2, "2nd");
        obj2.getParam2();
        System.out.println();
        //endregion newInstance

        //region method
        //公有方法调用
        System.out.println("公有方法调用");
        Method method = clazz.getMethod("getParam1");
        method.invoke(obj);
        System.out.println();

        //私有方法调用
        System.out.println("私有方法调用");
        Method secretMethod = clazz.getDeclaredMethod("secretMethod", String.class, int.class);
        secretMethod.setAccessible(true);
        secretMethod.invoke(obj2, "secret", 2021);
        System.out.println();
        //endregion method

        //region filed
        //公有字段 字段访问与修改
        System.out.println("公有字段 字段访问与修改");
        Field param2Field = clazz.getDeclaredField("param2");
        System.out.println("param2Field is " + param2Field.get(obj2));
        param2Field.set(obj2, "param2被我修改了");
        System.out.println("param2Field is " + param2Field.get(obj2));
        System.out.println();

        //私有字段 字段访问与修改
        System.out.println("私有字段 字段访问与修改");
        Field secretParam1Field = clazz.getDeclaredField("secretParam1");
        secretParam1Field.setAccessible(true);
        System.out.println("secretParam1Field is " + secretParam1Field.get(obj2));
        secretParam1Field.setInt(obj2, 2021);
        System.out.println("secretParam1Field is " + secretParam1Field.get(obj2));
        System.out.println();
        //endregion filed

        //region annotation
        //反射操作注解
        System.out.println("获得注解的value值");
        AnnotationClazz annotationClazz = (AnnotationClazz) clazz.getAnnotation(AnnotationClazz.class);
        System.out.println("Annotation-> " + annotationClazz.toString());
        System.out.println("AnnotationClazz value=" + annotationClazz.value());
        System.out.println();

        //获取私有字段
        Field validateParamField = clazz.getDeclaredField("validateParam");
        //获得类指定字段的注解
        ValidateParam validateParam = validateParamField.getAnnotation(ValidateParam.class);
        System.out.println("Annotation-> " + validateParam.toString());
        System.out.println("ValidateParam min=" + validateParam.min());
        System.out.println("ValidateParam max=" + validateParam.max());
        System.out.println("ValidateParam value=" + validateParam.value());
        System.out.println();
        //修改私有属性
        validateParamField.setAccessible(true);
        validateParamField.setInt(obj2, 2021);
        System.out.println("validateParamField is " + validateParamField.get(obj2));
        System.out.println();

        //公有字段
        Field validateParam2Field = clazz.getDeclaredField("validateParam2");
        //字段的注解
        ValidateParam validateParam2 = validateParam2Field.getAnnotation(ValidateParam.class);
        System.out.println("Annotation-> " + validateParam2.toString());
        //修改公有属性
        validateParam2Field.setInt(obj2, 10086);
        System.out.println("validateParam2Field is " + validateParam2Field.get(obj2));
        //endregion annotation
    }
}
