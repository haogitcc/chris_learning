package com.chris.test.days02;

import com.chris.test.aaclazz.MyRunnableImpl;
import com.chris.test.aaclazz.MyThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class TestThread {
    private static final String TAG = "TestThread";

    public static void main(String[] args) {
//        testNormalThread();
//        testMyThread();
//        testMyRunnableImpl();
        testThradPool();
    }

    private static void testThradPool() {
        //线程池
        System.out.println("线程池： ");
        int taskSize = 3;
        ExecutorService pool = Executors.newFixedThreadPool(taskSize);
        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ": run");
            }
        });

        pool.execute(new MyRunnableImpl());
        pool.execute(new MyRunnableImpl());
        pool.execute(new MyRunnableImpl());
        pool.execute(new MyRunnableImpl());
        pool.execute(new MyRunnableImpl());

        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "call success";
            }
        };

        Future<String> future = pool.submit(callable);
        try {
            String result = future.get(5000, TimeUnit.MICROSECONDS);
            System.out.println("result=" + result);
        } catch (ExecutionException | InterruptedException | TimeoutException e) {
            e.printStackTrace();
        }

        pool.shutdown();
    }

    private static void testMyRunnableImpl() {
        //实现Runnable
        System.out.println("实现Runnable： ");
        MyRunnableImpl myRunnable = new MyRunnableImpl();
        myRunnable.start();
    }

    private static void testMyThread() {
        //继承Thread
        System.out.println("继承Thread： ");
        MyThread myThread = new MyThread();
        myThread.start();
    }

    private static void testNormalThread() {
        // 正常
        System.out.println("正常线程： ");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ": run");
            }
        });
        thread.start();
    }
}
