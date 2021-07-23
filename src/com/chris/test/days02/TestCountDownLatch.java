package com.chris.test.days02;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class TestCountDownLatch {
    private static final String TAG = "TestCountDownLatch";

    public static void main(String[] args) {
        try {
//            test();
//            testCyclicBarrier();
            testSemaphore();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void testSemaphore() {
        int workerCount = 10;
        Semaphore semaphore = new Semaphore(workerCount);
        for (int i=0; i < workerCount; i++){
            new Worker(i, semaphore).start();
        }
    }

    static void test() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("子线程" + Thread.currentThread().getName() + "正在执行");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕");
                countDownLatch.countDown();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("子线程" + Thread.currentThread().getName() + "正在执行");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕");
                countDownLatch.countDown();
            }
        }).start();

        System.out.println("等待2线程执行完毕");
        countDownLatch.await();
        System.out.println("2个线程已经执行完毕");
    }

    static void testCyclicBarrier(){
        int workerCount = 10;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(workerCount);
        for (int i=0; i < workerCount; i++){
            new Worker(i, cyclicBarrier).start();
        }
    }

    private static class Worker extends Thread {
        private int id;
        private CyclicBarrier cyclicBarrier;
        private boolean isCyclicBarrier;
        private Semaphore semaphore;
        private boolean isSemaphore;
        public Worker(int id, CyclicBarrier cyclicBarrier) {
            this.id = id;
            this.cyclicBarrier = cyclicBarrier;
            this.isCyclicBarrier = true;
            this.isSemaphore = false;
        }

        public Worker(int id, Semaphore semaphore) {
            this.id = id;
            this.semaphore = semaphore;
            this.isCyclicBarrier = false;
            this.isSemaphore = true;
        }

        @Override
        public void run() {
            if(isCyclicBarrier) {
                try {
                    Thread.sleep(3000);
                    System.out.println("子线程_" + id + ", " + Thread.currentThread().getName() + "执行完毕");
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println("子线程_" + id + ", " + Thread.currentThread().getName() + "所有线程执行完毕");
            }
            else if(isSemaphore) {
                try {
                    semaphore.acquire();
                    System.out.println("子线程_" + id + ", " + Thread.currentThread().getName() + "占用");
                    Thread.sleep(2000);
                    System.out.println("子线程_" + id + ", " + Thread.currentThread().getName() + "执行完毕");
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
