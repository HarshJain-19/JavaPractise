package multiThreading;

class Counter {
    int count = 0;

    public void incrementAndGet() {
        ++count; // not thread-safe
    }

    public synchronized void safeIncrementAndGet() {
        ++count; // thread-safe
    }
}

public class SynchronizationExample {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++)
                counter.incrementAndGet();
//                counter.safeIncrementAndGet();
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++)
                counter.incrementAndGet();
//                counter.safeIncrementAndGet();
        });

        t1.start(); t2.start();
        t1.join(); t2.join();

        System.out.println("Final count: " + counter.count); // Expected: 200
    }
}

