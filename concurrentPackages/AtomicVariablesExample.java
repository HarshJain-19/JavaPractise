package concurrentPackages;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicVariablesExample {

    private static int counter = 0;
    private static final AtomicInteger atomicCounter = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i=0; i<10000; i++) counter++;
        });
        Thread t2 = new Thread(() -> {
            for (int i=0; i<10000; i++) counter++;
        });
        Thread t3 = new Thread(() -> {
            for (int i=0; i<10000; i++) atomicCounter.getAndIncrement();
        });
        Thread t4 = new Thread(() -> {
            for (int i=0; i<10000; i++) atomicCounter.getAndIncrement();
        });

        t1.start(); t2.start(); t3.start(); t4.start();
        t1.join(); t2.join(); t3.join(); t4.join();

        System.out.println("counter = " + counter);
        System.out.println("atomicCounter = " + atomicCounter);
    }
}
