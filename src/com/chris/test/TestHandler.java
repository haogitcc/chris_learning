//package com.chris.test;
//
//import android.os.AsyncTask;
//import android.os.Build;
//import android.os.Handler;
//import android.os.Message;
//
//import java.util.concurrent.Executors;
//import java.util.concurrent.ThreadFactory;
//
//public class TestHandler {
//    private static final String TAG = "TestHandler";
//    //region Handler+Thread
//    private static final int OPT_FINISH = 0;
//    private Handler handler = new Handler() {
//        @Override
//        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
//            if(msg.what == OPT_FINISH) {
//                String obj = (String) msg.obj;
//                Log.d(TAG, obj);
//            }
//        }
//    };
//    private TaskThread taskThread = new TaskThread();
//
//    private class TaskThread implements Runnable {
//        private boolean running = false;
//        @Override
//        public void run() {
//            running = true;
//            while (running){
//                // post
//                handler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        // do some ui thread things
//                    }
//                });
//            }
//            // sendMessage
//            Message message = Message.obtain();
//            message.what = OPT_FINISH;
//            message.obj = "operation is finish!";
//            handler.sendMessage(message);
//        }
//
//        public void setRunning(boolean running) {
//            this.running = running;
//        }
//    }
//    //endregion Handler+Thread
//
//    //region AsyncTask
//    class MyAsyncTask extends AsyncTask<Integer, Integer, String> {
//
//        @Override
//        protected void onPreExecute() {
//            //do ui things
//            super.onPreExecute();
//        }
//
//        @Override
//        protected String doInBackground(Integer... integers) {
//            for(int i=0;i<=100;i++){
//                publishProgress(i);
//                try {
//                    Thread.sleep(integers[0]);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//            return "ִ�����";
//        }
//
//        @Override
//        protected void onProgressUpdate(Integer... values) {
//            //do ui things
//            super.onProgressUpdate(values);
//        }
//
//        @Override
//        protected void onPostExecute(String s) {
//            //do ui things
//            super.onPostExecute(s);
//        }
//    }
//    //endregion AsyncTask
//
//    //region ThreadPoolExecutor
//    private int corePoolSize = 3;
//    private ThreadFactory threadFactory = new ThreadFactory() {
//        @Override
//        public Thread newThread(Runnable r) {
//            return null;
//        }
//    };
//
//    void TestThreadPool() {
//        // 1. ����һ���������̳߳أ�ÿ�ύһ������ʹ���һ���̣߳�ֱ���ﵽ�ص���󳤶ȣ���ʱ�̳߳ػᱣ�ֳ��Ȳ��ٱ仯
//        Executors.newFixedThreadPool(corePoolSize);
//        Executors.newFixedThreadPool(corePoolSize, threadFactory);
//        // 2.����һ���ɻ�����̳߳أ������ǰ�̳߳صĳ��ȳ����˴������Ҫʱ�����������Ļ��տ��е��̣߳�����Ҫ����ʱ��
//        // ��������������µ��̣߳�������Գصĳ������κ�����
//        Executors.newCachedThreadPool();
//        Executors.newCachedThreadPool(threadFactory);
//        //3.����һ���������̳߳أ�����֧�ֶ�ʱ���Լ������Ե�����ִ�У�������Timer
//        Executors.newScheduledThreadPool(corePoolSize);
//        Executors.newScheduledThreadPool(corePoolSize, threadFactory);
//        //4. ����һ�����̻߳���executor����ֻ����Ψһ��worker�߳���ִ������
//        Executors.newSingleThreadExecutor();
//        Executors.newSingleThreadExecutor(threadFactory);
//        //5.
//        Executors.newSingleThreadScheduledExecutor();
//        Executors.newSingleThreadScheduledExecutor(threadFactory);
//        //6.
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//            int parallelism = 1;
//            Executors.newWorkStealingPool();
//            Executors.newWorkStealingPool(parallelism);
//        }
//    }
//    //endregion ThreadPoolExecutor
//
//    //region IntentService
//
//    //endregion IntentService
//
//}
