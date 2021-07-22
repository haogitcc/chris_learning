package com.chris.test;

public class testThreadLocalMap {
    static ThreadLocal<Car> threadLocal = new ThreadLocal();
    public static void main(String[] args) {
        test();
    }

    private static void test() {
        Car car = new Car(1001);
        threadLocal.set(car);
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
        Car car = threadLocal.get();
        System.out.println(Thread.currentThread().getName() + ", Car id=" + car.getId());
    }

    private static void step2() {
        Car car = threadLocal.get();
        System.out.println(Thread.currentThread().getName() + ", before set Car id=" + car.getId());
        car.setId(1002);
        System.out.println(Thread.currentThread().getName() + ", after set Car id=" + car.getId());
    }
}
