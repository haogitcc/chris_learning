package com.chris.test;

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
        Log.d(TAG, "main");
    }

    void Test() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
        thread.start();

        MyThread myThread = new MyThread();
        myThread.start();

        MyRunnable myRunnable = new MyRunnable(1000);
        myRunnable.run();

        int taskSize = 3;
        ExecutorService pool = Executors.newFixedThreadPool(taskSize);
        pool.execute(myRunnable);

        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "call success";
            }
        };

        Future<String> future = pool.submit(callable);
        try {
            String result = future.get(5000, TimeUnit.MICROSECONDS);
            Log.d(TAG, "result=" + result);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            //Timeout
            e.printStackTrace();
        }
        pool.shutdown();
    }

    class MyThread extends Thread {
        private static final String TAG = "MyThread";

        @Override
        public void run() {
            super.run();
            Log.d(TAG, "run " + Thread.currentThread().getName());
        }
    }

    // extends class Car, need to implements Runnable
    class MyRunnable extends Car implements Runnable {
        private static final String TAG = "MyRunnable";

        MyRunnable(int id) {
            super(id);
        }

        @Override
        public void run() {
            Log.d(TAG, "run " + Thread.currentThread().getName());
        }
    }
}
