package com.example.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class Foo {
    private int i = 1;
    private ReentrantLock lock;
    private Condition secondCondition, thirdCondition;

    public Foo() {
        lock = new ReentrantLock();
        secondCondition = lock.newCondition();
        thirdCondition = lock.newCondition();
    }

    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        i = 2;
        secondCondition.signal();
        lock.unlock();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        while (i != 2) {
            secondCondition.await();
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        i = 3;
        thirdCondition.signal();
        lock.unlock();
    }

    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        while (i != 3) {
            thirdCondition.await();
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        lock.unlock();
    }
}

