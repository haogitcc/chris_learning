package com.chris.test;

public class TestClazz {
    void Test() {
        Car wuLing = new WuLing();
    }

    class Window {
        void Open() {

        }
        void Close() {

        }
    }

    interface Run {
        void Up();
        void Down();
        void Left();
        void Right();
    }

    class WuLing extends Car implements Run {
        Speed speed;
        Window window_01;
        Window window_02;
        Window window_03;
        Window window_04;

        WuLing() {
            speed = new Speed() {
                @Override
                void fast() {

                }

                @Override
                void slow() {

                }
            };
            window_01 = new Window();
            window_02 = new Window();
            window_03 = new Window();
            window_04 = new Window();
        }

        void pushFast() {
            speed.fast();
            Up();
        }

        void pushDown() {
            speed.slow();
            Down();
        }

        @Override
        public void Up() {
            super.Up();
        }

        @Override
        public void Down() {
            super.Down();
        }

        void OpenWindows() {
            window_01.Open();
            window_02.Open();
            window_03.Open();
            window_04.Open();
        }
    }

    abstract class Speed {
        abstract void fast();
        abstract void slow();
    }

    class Car implements Run {
        private String name;
        private int id;

        public String getName() {
            return name;
        }

        public int getId() {
            return id;
        }

        @Override
        public void Up() {

        }

        @Override
        public void Down() {

        }

        @Override
        public void Left() {

        }

        @Override
        public void Right() {

        }
    }
}

