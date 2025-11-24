package nestedClasses;

public class AnonymousInnerClassPractise2 {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Child Thread");
            }
        });

        t.start();

        System.out.println("Main Thread");
    }
}

