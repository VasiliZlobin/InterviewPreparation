package ru.vasili_zlobin.interview.threads.pingpong;

public class PingPongThread extends Thread {
    private final int waitIndex;

    public PingPongThread(int waitIndex) {
        this.waitIndex = waitIndex;
    }

    @Override
    public void run() {
        try {
            PingPongMain.concurrentPrint(waitIndex);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
