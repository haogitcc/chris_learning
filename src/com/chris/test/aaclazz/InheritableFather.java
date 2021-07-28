package com.chris.test.aaclazz;

import java.lang.reflect.Field;

@Inheritable
public class InheritableFather {
    @ValidateParam(min = 0, max = 99, value = -1)
    private int age;
    @ValidateParam(min = 0, max = 200, value = -1)
    private int height;

    public InheritableFather() {
        // InheritableBase是否具有 Inheritable Annotation
        System.out.println("InheritableFather:"+InheritableFather.class.isAnnotationPresent(Inheritable.class));
        try {
            this.age = this.getClass().getDeclaredField("age").getAnnotation(ValidateParam.class).value();
            this.height = this.getClass().getDeclaredField("height").getAnnotation(ValidateParam.class).value();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public void setAge(int age) {
        checkParam(age, "age");
        this.age = age;
    }

    private void checkParam(int param, String paramName) {
        try {
            Field field = this.getClass().getDeclaredField(paramName);
            ValidateParam validateParam = field.getAnnotation(ValidateParam.class);
            if(param < validateParam.min() || param > validateParam.max()) {
                throw new IllegalArgumentException(param + " is a wrong " + paramName
                        + ", param range must be [" + validateParam.min() + ", " + validateParam.max() +"]");
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public int getAge() {
        return age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        checkParam(height, "height");
        this.height = height;
    }
}
