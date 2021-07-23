package com.chris.test.aaclazz;

// extends class Car, need to implements Runnable
public class MyRunnableImpl extends Person implements Runnable {
    private Thread t;
    public MyRunnableImpl() {
        System.out.println("MyRunnableImpl: 实现Runnable");
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": run");
    }

    public void start() {
        if(t == null) {
            t =new Thread(this);
            t.start();
        }
    }
}
