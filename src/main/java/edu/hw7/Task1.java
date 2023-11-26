package edu.hw7;

import java.util.concurrent.atomic.AtomicLong;

public final class Task1 {
    public static AtomicLong count;

    public void increment(int iterations, int threadsNum) throws InterruptedException {
        count = new AtomicLong(0);
        Thread[] threads = new Thread[threadsNum];

        for (int i = 0; i < threadsNum; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < iterations; j++) {
                    count.incrementAndGet();
                }
            });
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
    }
}
