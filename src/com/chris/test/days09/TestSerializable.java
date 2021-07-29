package com.chris.test.days09;

public class TestSerializable {
    public static void main(String[] args) {
        new SerializableClazz();
        Resume resume = new Resume();
        Resume resume1 = (Resume) resume.clone();
    }
}
