package thread.thread_art.count_down_latch;

import utils.Print;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
    static CountDownLatch c = new CountDownLatch(1);

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            public void run() {
                Print.println(1);
                c.countDown();
                Print.println(2);
                c.countDown();
            }
        }).start();
        c.await();
        Print.println("3");
    }


}
