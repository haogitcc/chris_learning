package com.chris.test.days08;

import java.util.ArrayList;
import java.util.List;

public class TestGenerics {
    public static void main(String[] args) {
        // 创建不同类型数组： Integer, Double 和 Character
        Integer[] intArray = { 1, 2, 3, 4, 5 };
        Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
        Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };

        System.out.println( "整型数组元素为:" );
        printArray( intArray  ); // 传递一个整型数组

        System.out.println( "\n双精度型数组元素为:" );
        printArray( doubleArray ); // 传递一个双精度型数组

        System.out.println( "\n字符型数组元素为:" );
        printArray( charArray ); // 传递一个字符型数组

        System.out.println();
        List<String> list = new ArrayList<>();
        list.add("abandon");
        list.add("noise");
        list.add("amazing");
        list.add("avoid");
        showGeneric(new Generic<List<String>>(list));
        showGeneric(new Generic<Integer>(11));
        showGeneric(new Generic<String>("I'm a key value."));
    }

    private static void showGeneric(Generic<? extends Object> obj) {
        System.out.println("key = " + obj.getKey());
        System.out.println();
    }

    private static<E> void printArray(E[] intArray) {
        for (E element: intArray) {
            System.out.print(" " + element);
        }
        System.out.println();
    }

    // 此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型
    // 在实例化泛型类时，必须指定T的具体类型
    public static class Generic<T>{
        //key这个成员变量的类型为T,T的类型由外部指定
        private T key;

        public Generic(T key) { //泛型构造方法形参key的类型也为T，T的类型由外部指定
            this.key = key;
        }

        public T getKey(){ //泛型方法getKey的返回值类型为T，T的类型由外部指定
            return key;
        }
    }

    public class G<C, D> {
        C c;
        D d;

        void get(C c, D d) {
            
        }
    }
}
