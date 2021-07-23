package com.chris.test.days02;

import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestLock {
    private static final String TAG = "TestLock";
    private static final int SLEEP_MS = 1;
    private static Random random = new Random();

    public static void main(String[] args) {
        System.out.println("main");
        testSyncData();
//        testReadWriteData();
//        testLockData();
    }

    private static void testSyncData() {
        SyncData syncData = new SyncData();
        for(int i = 0; i < 30; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " run");
                    int data = random.nextInt(30);
                    System.out.println(Thread.currentThread().getName() + " set data=" + data);
                    syncData.setSyncData(data);
                    try {
                        Thread.sleep(SLEEP_MS);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " get data=" + syncData.getSyncData());
                    System.out.println("================================================================");
                }
            }, "thread_SyncData_" + i).start();
        }
    }

    private static void testReadWriteData() {
        ReadWriteData syncData = new ReadWriteData();
        for(int i = 0; i < 30; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " run");
                    int data = random.nextInt(30);
                    System.out.println(Thread.currentThread().getName() + " set data=" + data);
                    syncData.setData(data);
                    try {
                        Thread.sleep(SLEEP_MS);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " get data=" + syncData.getData());
                    System.out.println("================================================================");
                }
            }, "thread_ReadWriteData_" + i).start();
        }
    }

    private static void testLockData() {
        LockData syncData = new LockData();
        for(int i = 0; i < 30; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " run");
                    int data = random.nextInt(30);
                    System.out.println(Thread.currentThread().getName() + " set data=" + data);
                    try {
                        syncData.put(data);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        Thread.sleep(SLEEP_MS);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " get data=" + syncData.take());
                    System.out.println("================================================================");
                }
            }, "thread_LockData_" + i).start();
        }
    }
}

//region synchronized
class SyncData {
    private int syncData;
    synchronized void setSyncData(int data) {
        this.syncData = data;
    }

    synchronized int getSyncData() {
        return this.syncData;
    }
}
//endregion synchronized

//region ReadWriteLock
class ReadWriteData {
    private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    private int data;
    void setData(int data) {
        rwl.writeLock().lock();
        try {
            this.data = data;
        }
        finally {
            rwl.writeLock().unlock();
        }
    }

    int getData() {
        rwl.readLock().lock();
        try {
            return this.data;
        }
        finally {
            rwl.readLock().unlock();
        }
    }
}
//endregion ReadWriteLock

//region lock
class LockData {
    private Lock lock = new ReentrantLock();
    private Condition notFull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();
    private Object[] items = new Object[100];
    int putprt;
    int takeprt;
    int count;

    void put(Object obj) throws InterruptedException {
        lock.lock();
        try {
            //������������ȴ�notFull����������д�̣߳�
            while (count == items.length) {
                notFull.await();
            }
            items[putprt] = obj;
            if(++putprt == items.length) {
                putprt = 0;
            }
            ++count;

            //���Ѷ��߳�
            notEmpty.signal();
        }
        finally {
            lock.unlock();
        }
    }

    Object take() {
        lock.lock();
        try {
            // �������Ϊ�գ���ȴ�notEmpty�������������̣߳�
            while (count == 0) {
                notEmpty.signal();
            }
            Object obj = items[takeprt];
            if(++takeprt == items.length) {
                takeprt = 0;
            }
            --count;
            //����д�߳�
            notFull.signal();
            return obj;
        }
        finally {
            lock.unlock();
        }
    }
}
//endregion lock

//region Semaphore
class SemaphoreData {
    Semaphore semaphore = new Semaphore(5);

    void setData() throws InterruptedException {
        semaphore.acquire();
        try {

        }
        finally {
            semaphore.release();
        }
    }
}
//endregion Semaphore

//region BlockQueue
class BlockQueueData {
    //公平、非公平
    private ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<String>(100, false);
    //两个独立锁提高并发
    private LinkedBlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<>(100);
    //compareTo 排序实现优先
    private PriorityBlockingQueue<DelayedData> priorityBlockingQueue = new PriorityBlockingQueue<>(100);
    //不存储数据、可用于传递数据
    private SynchronousQueue<String> synchronousQueue = new SynchronousQueue<>(false);
    //缓存失效、定时任务
    private DelayQueue<DelayedData> delayQueue = new DelayQueue<DelayedData>(priorityBlockingQueue);

    private LinkedTransferQueue<String> linkedTransferQueue = new LinkedTransferQueue<>();

    private LinkedBlockingDeque<String> linkedBlockingDeque = new LinkedBlockingDeque<>();

    void add(String data) throws InterruptedException {
        arrayBlockingQueue.add(data);
        linkedBlockingQueue.add(data);
        priorityBlockingQueue.add(new DelayedData(data));
        synchronousQueue.add(data);
        delayQueue.add(new DelayedData(data));
        linkedTransferQueue.transfer(data);
        linkedBlockingDeque.addFirst(data);
    }

    private class DelayedData implements Delayed {
        private final String data;

        public DelayedData(String data) {
            this.data = data;
        }

        public String getData() {
            return data;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return 0;
        }

        @Override
        public int compareTo(Delayed o) {
            return 0;
        }
    }
}
//endregion BlockQueue
