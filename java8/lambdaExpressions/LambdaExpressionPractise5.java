package java8.lambdaExpressions;

public class LambdaExpressionPractise5 {
    public static void main(String[] args) {
        Runnable myRunnable = () -> {
            Thread.currentThread().setName("My Thread");
            System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getState());
        };

        Thread myThread1 = new Thread(myRunnable);
        myThread1.start();

        Thread myThread2 = new Thread(() -> System.out.println(Thread.currentThread().getId()));
        myThread2.start();
    }
}
