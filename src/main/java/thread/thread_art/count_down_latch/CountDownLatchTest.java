package thread.thread_art.count_down_latch;

import utils.Print;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
    static CountDownLatch c = new CountDownLatch(3);

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
//countDown()与await()联合使用：
//初始化时候，new CountDownLatch(N):其中需要使用countDown()达到N次，await()线程可继续执行，否则暂时等待