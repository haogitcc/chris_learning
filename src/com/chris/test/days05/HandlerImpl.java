package com.chris.test.days05;

public class HandlerImpl implements Handler {

    @Override
    public void handle(String data) {
        System.out.println("handle data is #" + data + "#");
    }
}
