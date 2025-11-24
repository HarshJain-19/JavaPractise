package Locks;

import java.util.concurrent.locks.ReentrantLock;

class SharedReentrantResource {
    private final ReentrantLock lock = new ReentrantLock();

    public void printLockDetails(String msg) {
        lock.lock();
        try {
            System.out.println("start msg = " + msg);
            Thread.sleep(1000);

            System.out.println("isLocked: " + lock.isLocked());
            System.out.println("hold count: " + lock.getHoldCount());
            System.out.println("queueLength: " + lock.getQueueLength());
            System.out.println("is Fair: " + lock.isFair());
            System.out.println("isHeldByCurrentThread: " + lock.isHeldByCurrentThread());
            System.out.println("hasQueuedThreads: " + lock.hasQueuedThreads());

            System.out.println("end msg = " + msg);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            System.out.println();
            lock.unlock();
        }
    }
}

public class ReentrantLockPractise {
    public static void main(String[] args) {
        SharedReentrantResource sharedReentrantResource = new SharedReentrantResource();

        Runnable task1 = () -> sharedReentrantResource.printLockDetails("One");
        Runnable task2 = () -> sharedReentrantResource.printLockDetails("Two");
        Runnable task3 = () -> sharedReentrantResource.printLockDetails("Three");

        new Thread(task1).start();
        new Thread(task2).start();
        new Thread(task3).start();
    }
}
