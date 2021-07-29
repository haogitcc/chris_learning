package com.chris.test.days05;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CostInvocationHandler implements InvocationHandler {
    // 目标对象
    private final Object target;

    public CostInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("call method " + method + " ,args " + args);
        long start = System.currentTimeMillis();
        try {
            // 将请求转发给目标对象
            return method.invoke(this.target, args);
        } finally {
            long end = System.currentTimeMillis();
            System.out.println("cost " + (end - start) + "ms");
        }
    }
}
