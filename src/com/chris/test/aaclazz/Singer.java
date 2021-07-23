package com.chris.test.aaclazz;

import com.chris.test.aainterfaces.Sing;
import com.chris.test.aainterfaces.Speak;

public class Singer extends Person implements Speak, Sing {
    public Singer() {
        System.out.println("一名歌手");
    }

    @Override
    public void walk() {
//        super.walk();
        System.out.println("重写：歌手走路");
    }

    @Override
    public void eat() {
//        super.eat();
        System.out.println("重写：歌手吃东西");
    }

    @Override
    public void speak() {
        System.out.println("歌手说话");
    }

    @Override
    public void sing() {
        System.out.println("歌手唱歌");
    }
}
