package com.chris.test.aaclazz;

public class ReflectionFatherClazz {
    private int secretParam;
    public int param;
    public int[] arrParam;

    public ReflectionFatherClazz() {
    }

    public ReflectionFatherClazz(int secretParam, int param) {
        this.secretParam = secretParam;
        this.param = param;
    }

    public int getSecretParam() {
        return secretParam;
    }

    public int getParam() {
        return param;
    }

    public int[] getArrParam() {
        return arrParam;
    }

    private void secretMethod() {
        System.out.println("secretMethod call");
    }
}
