package com.chris.test.days01;

import com.chris.test.aaclazz.*;

public class TestClazz {
    public static void main(String[] args) {
        //继承
        System.out.println("测试继承： ");
        Singer singer = new Singer();
        singer.speak();
        singer.sing();
        singer.walk();
        singer.walk(100);
        singer.eat();
        System.out.println("歌手" + (singer.isHuman()?"是":"不是") + "人类");

        //多态
        System.out.println();
        System.out.println("测试多态： ");
        Person father = new Father();
        System.out.println();
        Person mother = new Mother();
        System.out.println();
        Person son = new Son();
        System.out.println();
        Person daughter = new Daughter();
        System.out.println();

        System.out.println("该男性：");
        showInfo(father);
        System.out.println("该女性：");
        showInfo(mother);
        System.out.println("该男孩：");
        showInfo(son);
        System.out.println("该女孩：");
        showInfo(daughter);
        System.out.println("另一位男性：");
        showInfo(singer);

        //抽象
//        Human human = new Human(); // 抽象类不能被实例化

        //接口
        System.out.println();
        System.out.println("测试接口： ");
        Rapper rapper = new Rapper();
        rapper.rap();
        rapper.sing();
        rapper.speak();
        rapper.walk();
        rapper.walk(100);
        rapper.eat();

        //组合
        System.out.println();
        System.out.println("测试组合： ");
        Robot robot = new Robot();
        System.out.println();
        robot.sing();
        System.out.println();
        robot.rap();
    }

    private static void showInfo(Person person) {
        if(person instanceof Father){
            if(person instanceof Son) {
                System.out.println("是一个父亲的儿子");
            } else {
                System.out.println("是一名父亲");
            }
        } else if(person instanceof Mother) {
            if(person instanceof Daughter) {
                System.out.println("是一个母亲的女儿");
            } else {
                System.out.println("是一名母亲");
            }
        }  else {
            System.out.println("不清楚其身份");
        }
    }
}

