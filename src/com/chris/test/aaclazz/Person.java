package com.chris.test.aaclazz;

public class Person extends Human {
    private String name;

    public Person() {
        name = "null";
        System.out.println("一个人");
    }

    public void walk() {
        System.out.println("人走路");
    }

    public void walk(int step) {
        System.out.println("重载: 人走" + step + "步");
    }

    @Override
    void eat() {
        System.out.println("人吃东西");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void secretMethod() {
        System.out.println("secretMethod call");
    }
}
