package multiThreading;

public class ThreadJoinExample {
    public static void main(String[] args) throws InterruptedException {
        Thread worker = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Worker: " + i);
                try { Thread.sleep(500); } catch (InterruptedException e) {}
            }
        });

        worker.start();

        System.out.println("Main thread waiting for worker to finish...");
        worker.join(); // <--- main thread waits here
        System.out.println("Worker finished. Main thread resumes.");
    }
}


