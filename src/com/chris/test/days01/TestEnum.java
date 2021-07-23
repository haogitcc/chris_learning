package com.chris.test.days01;

public class TestEnum {
    private static final String TAG = "TestEnum";

    public static void main(String[] args) {
        System.out.println("enum: ");
        for(ENumber e : ENumber.values()){
            System.out.println("enum[" + e.ordinal() + "] is " + e);
        }

        System.out.println("enumClass: ");
        for(ENumberClzz eClzz : ENumberClzz.values()){
            System.out.println("enumClass[" + eClzz.ordinal() + "] is " + eClzz + ", desc is \""+eClzz.getDesc() + "\"");
        }

        System.out.println("valueOf("+ENumber.One.name()+") is " + ENumber.valueOf(ENumber.One.name()));

        for (Color c:Color.values()) {
            System.out.println("enumClass[" + c.ordinal() + "] is " + c + ", color is \""+c.getColor() + "\"");
        }
    }

    enum ENumber {
        One,
        Two,
        Three,
        Four
    }

    enum ENumberClzz {
        One("I am the first."),
        Two("I am the second."),
        Three("I am the third.")
        ;
        String desc;
        ENumberClzz(String desc){
            this.desc = desc;
        }

        public String getDesc() {
            return desc;
        }
    }

    enum Color{
        RED{
            @Override
            public String getColor(){//枚举对象实现抽象方法
                return "红色";
            }
        },
        GREEN{
            @Override
            public String getColor(){//枚举对象实现抽象方法
                return "绿色";
            }
        },
        BLUE{
            @Override
            public String getColor(){//枚举对象实现抽象方法
                return "蓝色";
            }
        },
        YELLOW {
            @Override
            public String getColor() {
                return "黄色";
            }
        };
        public abstract String getColor();//定义抽象方法
    }
}
