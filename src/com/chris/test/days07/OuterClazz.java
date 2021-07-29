package com.chris.test.days07;

public class OuterClazz {
    private static int siParam;
    private int secretParam;

    public OuterClazz() {
        siParam = 1;
        secretParam = 2;
    }

    public void test(int param) {
        int c = 11;
        //局部内部类
        class InnerClazz {
            private int a;

            public InnerClazz() {
                this.a = 10;
            }

            void print() {
                System.out.println("InnerClazz param=" + param);
                System.out.println("InnerClazz a=" + a);
                System.out.println("InnerClazz c=" + c);
            }
        }
        new InnerClazz().print();
    }

    public void test(MyClazz myClazz) {
        myClazz.run();
    }

    //成员内部类
    public class FiledInnerClazz {
        int secretParam;

        public FiledInnerClazz() {
            this.secretParam = 3;
            OuterClazz.this.siParam = 4;
            OuterClazz.this.secretParam = 5;
        }

        void print() {
            System.out.println("FiledInnerClazz print OuterClazz secretParam=" + OuterClazz.this.secretParam);
            System.out.println("FiledInnerClazz print FiledInnerClazz secretParam=" + FiledInnerClazz.this.secretParam);
            System.out.println("FiledInnerClazz print siParam=" + siParam);
        }
    }

    private class SecretFiledInnerClazz {
        public SecretFiledInnerClazz() {
            siParam = 6;
            secretParam = 7;
        }

        void print() {
            System.out.println("SecretFiledInnerClazz print siParam=" + siParam);
            System.out.println("SecretFiledInnerClazz print secretParam=" + siParam);
        }
    }

    //静态内部类
    private static class SecretStaticInnerClazz {
        public SecretStaticInnerClazz() {
            siParam = 8;
        }

        void print() {
            System.out.println("SecretStaticInnerClazz print siParam=" + siParam);
        }
    }

    public static class StaticInnerClazz {
        public StaticInnerClazz() {
            siParam = 9;
        }

        void print() {
            System.out.println("StaticInnerClazz print siParam=" + siParam);
        }
    }

    public void secretFiledInnerClazzPrint() {
        new SecretFiledInnerClazz().print();
    }

    public void secretSecretStaticInnerClazzprint() {
        new SecretStaticInnerClazz().print();
    }
}
