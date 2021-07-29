package com.chris.test.days05;
/**
 * Handler代理<br />
 * 实现Handler接口，记录耗时情况，并将请求发送给目标对象
 */
public class HandlerProxy implements Handler{
    private final Handler handler;

    public HandlerProxy(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void handle(String data) {
        long start = System.currentTimeMillis();
        this.handler.handle(data);
        long end = System.currentTimeMillis();
        System.out.println("cost " + (end - start) + " ms");
    }
}
