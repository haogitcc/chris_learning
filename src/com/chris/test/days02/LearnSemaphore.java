package com.chris.test.days02;

import java.util.concurrent.Semaphore;

public class LearnSemaphore {
    public static void main(String[] args) {
        System.out.println("main");
        test();
    }

    private static void test() {
        int workerCount = 10;
        Semaphore semaphore = new Semaphore(5);
        for(int i=1; i <= workerCount; i++) {
            new Worker(i, semaphore).start();
        }
    }

    private static class Worker extends Thread {
        int id;
        Semaphore semaphore;
        public Worker(int id, Semaphore semaphore) {
            this.id = id;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("worker_" + this.id + " using machine now...");
                Thread.sleep(20);
                System.out.println("worker_" + this.id + " release machine!");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
