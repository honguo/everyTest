package com.example.test;

public class ConcurrentPrint {
    public static void main(String[] args) throws InterruptedException {
        Foo foo = new Foo();
        Runnable printFirst = () -> {
            System.out.println(1);
        };

        Runnable printSecond = () -> {
            System.out.println(2);
        };

        Runnable printThird = () -> {
            System.out.println(3);
        };

        new Thread(() -> {
            try {
                foo.first(printFirst);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                foo.third(printThird);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                foo.second(printSecond);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

}


