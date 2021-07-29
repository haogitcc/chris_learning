package com.chris.test.days07;

public class TestInnerClass {
    public static void main(String[] args) {
        // 初始化Bean1
        TestInnerClass testInnerClass = new TestInnerClass();
        TestInnerClass.Bean1 bean1 = testInnerClass.new Bean1();
        bean1.I++;
        // 初始化Bean2
        Bean2 bean2 = new Bean2();
        bean2.J++;
        //初始化Bean3
        Bean.Bean3 bean3 = new Bean().new Bean3();
        bean3.k++;

        test();
    }

    class Bean1{
        public int I =0;
    }

    static class Bean2{
        public int J =0;
    }

    private static void test() {
        OuterClazz outerClazz = new OuterClazz();
        //局部内部类
        outerClazz.test(4);
        //访问公用成员内部类
        OuterClazz.FiledInnerClazz filedInnerClazz = outerClazz.new FiledInnerClazz();
        filedInnerClazz.print();
        //访问私有成员内部类
        outerClazz.secretFiledInnerClazzPrint();
        //匿名内部类
        outerClazz.test(
                //匿名内部类
                new MyClazz() {
                    @Override
                    void run() {
                        System.out.println("run");
                    }
                });

        //公有静态内部类
        OuterClazz.StaticInnerClazz staticInnerClazz = new OuterClazz.StaticInnerClazz();
        staticInnerClazz.print();
        //公有静态内部类
        outerClazz.secretSecretStaticInnerClazzprint();
    }
}
class Bean{
    class Bean3{
        public int k =0;
    }
}
