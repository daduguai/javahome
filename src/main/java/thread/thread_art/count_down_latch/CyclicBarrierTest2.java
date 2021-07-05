package thread.thread_art.count_down_latch;

import utils.Print;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest2 {
    static CyclicBarrier c = new CyclicBarrier(2, new A());

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    c.await();
                    Print.println("1");
                } catch (Exception e) {

                }
            }
        }).start();
        try {
            c.await();
        } catch (Exception e) {
        }
        Print.println(2);
    }

    static class A implements Runnable {
        @Override
        public void run() {
            Print.println(3);
        }
    }
}
