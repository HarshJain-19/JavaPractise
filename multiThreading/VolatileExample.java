package multiThreading;

public class VolatileExample {

// volatile keyword here makes sure that the changes made in one thread are immediately reflect in other thread

    private static volatile int vol = 0;
//    private static int vol = 0;

    public static void main(String[] args) {
        new ChangeVol().start();
        new SeeVol().start();
    }

    static class SeeVol extends Thread {
        @Override
        public void run() {
            int localVol = vol;
            while (localVol < 5) {
                if (localVol != vol) {
                    System.out.println("vol is changed to: " + vol + ", from: " + localVol);
                    localVol = vol;
                }
            }
        }
    }

    static class ChangeVol extends Thread {
        @Override
        public void run() {
            int localVol = vol;
            while (localVol < 5) {
                vol = ++localVol;
                System.out.println("incrementing vol: " + vol);
                try {
                    sleep(100);
                } catch (InterruptedException iex) {
                    iex.printStackTrace();
                }
            }
        }
    }
}
