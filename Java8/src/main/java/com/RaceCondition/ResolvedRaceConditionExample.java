package com.RaceCondition;


import com.model.Counter;

public class ResolvedRaceConditionExample {
    public static void main(String[] args) throws InterruptedException {
        final Counter counter = new Counter();

        // Create and start multiple threads to increment the counter
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    counter.increment();
                }
            });
            threads[i].start();
        }

        // Wait for all threads to finish
        for (Thread thread : threads) {
            thread.join();
        }

        // Print the final count
        System.out.println("Final count: " + counter.getCount()); // Expected: 10000


    }
}