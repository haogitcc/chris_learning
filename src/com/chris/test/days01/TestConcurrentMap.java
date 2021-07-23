package com.chris.test.days01;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

public class TestConcurrentMap {
    static ConcurrentHashMap<String, String> concurrentMap = new ConcurrentHashMap();
    static CountDownLatch countDownLatch = new CountDownLatch(3);
    public static void main(String[] args) {
        try {
            test();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void test() throws InterruptedException {
        new Thread(new DataPut(10)).start();
        new Thread(new DataPut(15)).start();
        new Thread(new DataPut(10)).start();
        countDownLatch.await();
        System.out.println("concurrentMap size=" + concurrentMap.size());
        for (String key:concurrentMap.keySet()) {
            System.out.println("#MAP# <"+key+", "+concurrentMap.get(key)+">");
        }
        System.out.println("countDownLatch.getCount()=" + countDownLatch.getCount());
    }

    private static class DataPut implements Runnable {
        private int count;
        public DataPut(int count) {
            this.count = count;
        }

        @Override
        public void run() {
            for(int i=1; i <= count; i++){
                String key = "key_" + Thread.currentThread().getName() + "_" + i;
                System.out.println("put " + key);
                concurrentMap.put(key, "value_" + i);
            }
            countDownLatch.countDown();
        }
    }
}
