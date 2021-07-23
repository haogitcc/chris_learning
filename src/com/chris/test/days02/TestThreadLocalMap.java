package com.chris.test.days02;

import com.chris.test.aaclazz.Person;

public class TestThreadLocalMap {
    //减少同一个线程内多个函数或者组件之间一些公共变量的传递的复杂度。（线程的一个属性）
    static ThreadLocal<Person> threadLocal = new ThreadLocal();
    public static void main(String[] args) {
        test();
    }

    private static void test() {
        Person person = new Person();
        threadLocal.set(person);
        try {
            step1();
            step2();
            step1();
        }
        finally {
            threadLocal.remove();
        }
    }

    private static void step1() {
        Person person = threadLocal.get();
        System.out.println(Thread.currentThread().getName() + ", person name=" + person.getName());
    }

    private static void step2() {
        Person person = threadLocal.get();
        System.out.println(Thread.currentThread().getName() + ", before set person name=" + person.getName());
        person.setName("1002");
        System.out.println(Thread.currentThread().getName() + ", after set person name=" + person.getName());
    }
}
