package ru.vasili_zlobin.interview.threads.lock;

public class CommonCounter {
    private int counter = 0;
    public void increment() {
        counter++;
    }
    public int getCounter() {
        return counter;
    }
}
