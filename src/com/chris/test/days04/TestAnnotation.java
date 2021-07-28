package com.chris.test.days04;

import com.chris.test.aaclazz.InheritableFather;
import com.chris.test.aaclazz.InheritableSon;

public class TestAnnotation {
    public static void main(String[] args) {
        InheritableSon father = new InheritableSon();
        try {
            System.out.println("age is " + father.getAge()
                    + ", height is " + father.getHeight());
            father.setAge(27);
            father.setHeight(180);
            System.out.println("age is " + father.getAge()
                    + ", height is " + father.getHeight());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
