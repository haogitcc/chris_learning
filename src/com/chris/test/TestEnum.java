package com.chris.test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class TestEnum {
    private static final String TAG = "TestEnum";

    public static void main(String[] args) {
        for(ETest eTest : ETest.values()){
            System.out.println(eTest + ", ordinal" + eTest.ordinal());
        }

        List<String> list = Collections.synchronizedList(new ArrayList<>());//new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");

        for (String s:list
        ) {

        }

        for(Iterator it = list.listIterator(); it.hasNext();){
            it.next();
        }

        Queue<String> queue = new ArrayDeque<>();
        queue.add("1");
        queue.add("2");
        queue.add("3");
        queue.add("4");

        Vector<String> vector = new Vector<>();
        vector.add("v1");
        vector.add("v2");
        vector.add("v3");

        List<String> list1 = new LinkedList<>();
        list1.add(null);
        list1.remove(null);

        Stack<String> stack = new Stack<>();
        stack.push("S1");
        stack.add("S2");

        Deque<String> deque = new ArrayDeque<>();
        deque.push("D1");

        TreeMap<String, List<String>> treeMap = new TreeMap<>();
        treeMap.put("AAAAA", list);

        List<String> list2 = new CopyOnWriteArrayList<>();
        list2.add("CPW1");

        Map<String, String> map = new ConcurrentHashMap<>();
        map.put("K1", "V1");

        List a = new ArrayList();
        a.add("String");
        a.add(1);
        a.add(1.0);

        Class car = null;
        try {
            car = Class.forName("com.rodinbell.jnidemotest.Car");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Car car1 = (Car) car.newInstance();
            car1.getId();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        Field[] fields = car.getFields();
        for(Field f : fields){
            Log.d(TAG, "public filed: " + f);
        }

        Field[] declaredFields = car.getDeclaredFields();
        for(Field f : declaredFields){
            Log.d(TAG, "declaredFields: " + f);
        }

        Method[] methods = car.getMethods();
        for(Method m: methods){
            Log.d(TAG, "methods: " + m.getName());
        }

        Thread t = new Thread();
        t.getClass();

        EnumMap<ETest, EClzz> eClzzEnumMap;
        eClzzEnumMap = new EnumMap<TestEnum.ETest, TestEnum.EClzz>(TestEnum.ETest.class);
        eClzzEnumMap.put(TestEnum.ETest.CHRIS, TestEnum.EClzz.CHRIS);

        String sep = File.separator;
        File file = new File("C:"+ sep +
                "Users" + sep +
                "ChrisRodinbell" + sep +
                "Desktop" + sep +
                "java");
        try {
            file.mkdirs();
            file.createNewFile();

            if(file.exists()){
                Thread.sleep(5000);
                file.delete();
                file = null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    enum ETest {
        CHRIS,
        DENG,
        FATHER
    }

    enum EClzz {
        CHRIS("I have a question"),
        DENG("I have a question for you");
        String desc;
        EClzz(String desc){
            this.desc = desc;
        }

        public String getDesc() {
            return desc;
        }
    }
}
