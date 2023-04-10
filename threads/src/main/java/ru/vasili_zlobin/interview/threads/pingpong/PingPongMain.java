package ru.vasili_zlobin.interview.threads.pingpong;

public class PingPongMain {
    private static final int ITERATIONS = 5;
    private static final String[] arrayStrings = new String[]{"ping ", "pong "};
    private static final Object monitor = new Object();
    private static int currentIndex;

    public static void main(String[] args) {
        currentIndex = 0;
        for (int i = 0; i < arrayStrings.length; i++) {
            PingPongThread thread = new PingPongThread(i);
            thread.start();
        }
    }

    public static void concurrentPrint(int nextIndex) throws InterruptedException {
        synchronized (monitor) {
            for (int i = 0; i < ITERATIONS; i++) {
                while (currentIndex != nextIndex) {
                    monitor.wait();
                }
                System.out.print(arrayStrings[nextIndex]);
                currentIndex++;
                if (currentIndex >= arrayStrings.length) {
                    currentIndex = 0;
                }
                Thread.sleep(500);
                monitor.notifyAll();
            }
        }
    }
}
