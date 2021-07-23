package com.chris.test.aaclazz;

public class MyThread extends Thread {
    public MyThread() {
        System.out.println("MyThread: 继承Thread");
    }

    @Override
    public void run() {
        super.run();
        System.out.println(Thread.currentThread().getName() + ": run");
    }
}

