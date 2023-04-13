package ru.vasili_zlobin.interview.threads.lock;

import java.util.concurrent.locks.ReentrantLock;

public class CounterThread extends Thread {
    ReentrantLock locker;
    CommonCounter commonCounter;

    public CounterThread(ReentrantLock locker, CommonCounter commonCounter) {
        this.locker = locker;
        this.commonCounter = commonCounter;
    }

    @Override
    public void run() {
        locker.lock();
        try {
            for (int i = 0; i < Main.ITERATIONS; i++) {
                Thread.sleep(200);
                commonCounter.increment();
                System.out.printf("%s %d \n", Thread.currentThread().getName(), commonCounter.getCounter());
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            locker.unlock();
        }
    }
}
