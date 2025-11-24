package multiThreading;

public class ThreadLifeExample {

    public static void main(String[] args) {

        Thread t = new Thread(() -> {
            System.out.println("Thread running");
            try { Thread.sleep(500); } catch (InterruptedException ignored) {}
            System.out.println("Thread ending");
        });

        System.out.println("State before start: " + t.getState());
        t.start();
        try {
            Thread.sleep(100); // let it run
            System.out.println("State while running: " + t.getState());
            t.join();
        } catch (InterruptedException e) {}
        System.out.println("State after join: " + t.getState());
    }
}
