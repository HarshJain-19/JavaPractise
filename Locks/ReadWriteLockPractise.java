package Locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class SharedReadWriteLockResource {
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private final Lock readLock = readWriteLock.readLock();
    private final Lock writeLock = readWriteLock.writeLock();

    private int value = 0;

    // Read Method
    public int readValue() {
        readLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " reading value: " + value);
            return value;
        } finally {
            readLock.unlock();
        }
    }

    // Write method
    public void writeValue(int newValue) {
        writeLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " writing value: " + newValue);
            value = newValue;
        } finally {
            writeLock.unlock();
        }
    }

}

public class ReadWriteLockPractise {
    public static void main(String[] args) {
        SharedReadWriteLockResource sharedReadWriteLockResource = new SharedReadWriteLockResource();

        // Multiple readers
        Runnable reader = () -> {
            for (int i = 0; i < 3; i++) {
                sharedReadWriteLockResource.readValue();
                try { Thread.sleep(100); } catch (InterruptedException e) {}
            }
        };

        // One writer
        Runnable writer = () -> {
            for (int i = 1; i <= 3; i++) {
                sharedReadWriteLockResource.writeValue(i * 10);
                try { Thread.sleep(200); } catch (InterruptedException e) {}
            }
        };

        new Thread(reader, "Reader-1").start();
        new Thread(reader, "Reader-2").start();
        new Thread(writer, "Writer").start();
    }
}
