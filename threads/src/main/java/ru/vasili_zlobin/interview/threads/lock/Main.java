package ru.vasili_zlobin.interview.threads.lock;

import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static final int ITERATIONS = 5;

    public static void main(String[] args) {
        CommonCounter commonCounter = new CommonCounter();
        ReentrantLock locker = new ReentrantLock();
        for (int i = 0; i < ITERATIONS; i++) {
            CounterThread thread = new CounterThread(locker, commonCounter);
            thread.setName("Thread " + i);
            thread.start();
        }
    }
}
