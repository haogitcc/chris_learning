package com.chris.test.aaclazz;

import com.chris.test.aainterfaces.Rap;

public class Rapper extends Singer implements Rap {
    public Rapper() {
        System.out.println("一名说唱歌手");
    }

    @Override
    public void rap() {
        System.out.println("说唱歌手rap");
    }

    @Override
    public void sing() {
        super.sing();
        System.out.println("说唱歌手唱歌");
    }
}
