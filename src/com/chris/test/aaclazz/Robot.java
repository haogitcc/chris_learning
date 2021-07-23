package com.chris.test.aaclazz;

public class Robot {
    private Rapper rapper;
    private Daughter girl;

    public Robot() {
        this.rapper = new Rapper();
        this.girl = new Daughter();
    }

    public void sing() {
        girl.walk();
        rapper.sing();
    }

    public void rap() {
        girl.walk();
        rapper.rap();
    }
}
