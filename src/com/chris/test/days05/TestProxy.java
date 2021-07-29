package com.chris.test.days05;

import java.lang.reflect.Proxy;

public class TestProxy {
    public static void main(String[] args) {
//        testStaticProxy();
        testDynamicProxy();
    }

    private static void testDynamicProxy() {
        Handler handler = new HandlerImpl();

        CostInvocationHandler invocationHandler = new CostInvocationHandler(handler);

        Class cls = Proxy.getProxyClass(TestProxy.class.getClassLoader(), Handler.class);

        Handler proxy = (Handler) Proxy.newProxyInstance(TestProxy.class.getClassLoader(),
                new Class[]{ Handler.class },
                invocationHandler);

        System.out.println("invoke method");
        proxy.handle("Test");
        System.out.println("isProxyClass: " + Proxy.isProxyClass(cls));
        System.out.println("getInvocationHandler: " + (invocationHandler == Proxy.getInvocationHandler(proxy)));
    }

    private static void testStaticProxy() {
        Handler handler = new HandlerImpl();
        Handler handlerProxy = new HandlerProxy(handler);
        handlerProxy.handle("static");
    }
}
