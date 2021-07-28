package com.chris.test.days04;

import com.chris.test.aaclazz.AnnotationClazz;
import com.chris.test.aaclazz.ReflectionClazz;
import com.chris.test.aaclazz.ValidateParam;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestReflect2 {

    public static void main(String[] args) {
        System.out.println("创建对象");
        ReflectionClazz reflectionClazz = new ReflectionClazz();
        reflectionClazz.getParam1();
        System.out.println();

        try {
            testObj();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void testObj() throws Exception {
        boolean show = true;
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

        //获取类的方法、属性等
        System.out.println("获取所有方法：");
        Method[] methods = clazz.getDeclaredMethods();
        for (Method m : methods) {
            System.out.println("Method-> " + m);
        }
        System.out.println();

        System.out.println("获取所有属性：");
        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            System.out.println("Field-> " + f);
        }
        System.out.println();

        System.out.println("获取Declared注解：");
        Annotation[] declaredAnnotations = clazz.getDeclaredAnnotations();
        for (Annotation a : declaredAnnotations) {
            System.out.println("DeclaredAnnotations-> " + a);
        }
        System.out.println();

        System.out.println("获取所有构造函数：");
        Constructor[] constructors = clazz.getDeclaredConstructors();
        for (Constructor c : constructors) {
            System.out.println("Constructor-> " + c);
        }
        System.out.println();

        System.out.println("获取DeclaredClasses: ");
        Class[] clazzes = clazz.getDeclaredClasses();
        for (Class clz : clazzes) {
            System.out.println("Class-> " + clz);
        }
        System.out.println();

        //调用指定方法
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

        //反射操作注解
        if (show) {
            //1.通过反射获得注解
            Annotation[] annotations = clazz.getAnnotations();
            if(annotations != null) {
                for (Annotation annotation : annotations) {
                    System.out.println("Annotation->" + annotation);
                }
            }

            //2.获得注解的value值
            AnnotationClazz validateParam = (AnnotationClazz) clazz.getAnnotation(AnnotationClazz.class);
            System.out.println("获得注解的value值: " + validateParam.value());

            //3.获得类指定字段的注解
            //私有字段
            Field validateParamField = clazz.getDeclaredField("validateParam");
            //字段的注解
            Annotation validateParam1 = validateParamField.getAnnotation(ValidateParam.class);
            System.out.println("Annotation-> " + validateParam1.toString());
            //修改私有属性
            validateParamField.setAccessible(true);
            validateParamField.setInt(obj2, 2021);
            System.out.println("validateParamField is " + validateParamField.get(obj2));

            //公有字段
            Field validateParam2Field = clazz.getDeclaredField("validateParam2");
            //字段的注解
            Annotation validateParam2 = validateParam2Field.getAnnotation(ValidateParam.class);
            System.out.println("Annotation-> " + validateParam2.toString());
            //修改公有属性
            validateParam2Field.setInt(obj2, 10086);
            System.out.println("validateParam2Field is " + validateParam2Field.get(obj2));
        }
    }
}
