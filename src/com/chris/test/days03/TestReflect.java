package com.chris.test.days03;

import com.chris.test.aaclazz.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestReflect {
    public static void main(String[] args) {
        test();
//        getDeclaredMethods:
//        method: public java.lang.String com.chris.test.aaclazz.Person.getName()
//        method: public void com.chris.test.aaclazz.Person.setName(java.lang.String)
//        method: public void com.chris.test.aaclazz.Person.walk(int)
//        method: public void com.chris.test.aaclazz.Person.walk()
//        method: void com.chris.test.aaclazz.Person.eat()
//        getDeclaredFields:
//        field: private java.lang.String com.chris.test.aaclazz.Person.name
//        getDeclaredConstructors:
//        constructor: public com.chris.test.aaclazz.Person()
        try {
            testObj();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void testObj() throws Exception {
        //获取 Person 类的 Class 对象
        Class clazz=Class.forName("com.chris.test.aaclazz.Person");
        //使用.newInstane 方法创建对象
        Person p = (Person) clazz.newInstance();
        p.walk();

        //获取构造方法并创建对象
        Constructor c = clazz.getDeclaredConstructor();
        //创建对象并设置属性
        Person p1 = (Person) c.newInstance();
        p1.walk(100);

        //通过反射调用方法
        //公有方法
        Person.class.getDeclaredMethod("walk", int.class).invoke(p1, 100);
        Person.class.getDeclaredMethod("setName", String.class).invoke(p1, "chris");
        //私有方法
        Method eatMethod = Person.class.getDeclaredMethod("eat");
        eatMethod.setAccessible(true);
        eatMethod.invoke(p1);

        //通过反射获取属性
        //私有属性
        Field nameField = Person.class.getDeclaredField("name");
        nameField.setAccessible(true);
        System.out.println("nameFiled is " + nameField.get(p1));
    }

    private static void test() {
        //编译时类型和运行时类型
//        Person person = new Singer();// 编译时类型为 Person，运行时类型为 Singer

        //反射 API 用来生成 JVM 中的类、接口或则对象的信息
        {
//            1. 调用某个对象的 getClass()方法
//            Person person = new Person();
//            Class clazz = person.getClass();
        }

        {
//            2. 调用某个类的 class 属性来获取该类对应的 Class 对象
//            Class clazz = Person.class;
        }

//        3. 使用 Class 类中的 forName()静态方法(最安全/性能最好)
        Class clazz = null;
        //获取 Person 类的 Class 对象
        try {
            clazz = Class.forName("com.chris.test.aaclazz.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //获取 Person 类的所有方法信息
        System.out.println("getDeclaredMethods:");
        Method[] methods = clazz.getDeclaredMethods();
        for (Method m:methods) {
            System.out.println("method: " + m.toString());
        }
        System.out.println();
        //获取 Person 类的所有成员属性信息
        System.out.println("getDeclaredFields:");
        Field[] field=clazz.getDeclaredFields();
        for(Field f:field){
            System.out.println("field: " + f.toString());
        }
        System.out.println();
        //获取 Person 类的所有构造方法信息
        System.out.println("getDeclaredConstructors:");
        Constructor[] constructor=clazz.getDeclaredConstructors();
        for(Constructor c:constructor){
            System.out.println("constructor: " + c.toString());
        }
    }
}
