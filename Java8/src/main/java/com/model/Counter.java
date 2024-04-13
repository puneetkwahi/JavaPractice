package com.model;

public class Counter {
    private int count = 0;

    // Synchronize the increment method to ensure thread safety
    public synchronized void increment() {
        count++; // Read-modify-write operation
    }

    public int getCount() {
        return count;
    }
}