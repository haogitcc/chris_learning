package com.chris.test.days03;

public class TestException {
    public static void main(String[] args) {
        try {
            System.out.println("div=" + div(10,0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static int div(int a, int b) throws Exception {
        if(b==0){
            throw new Exception("cannot be zero");
        }
        return a/b;
    }
}
