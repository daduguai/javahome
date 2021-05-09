package thread.communication;

import utils.Print;

public class WaitAndNotify {

    public static void main(String[] args) {
        try{
            final Object lock = new Object();
            Thread thread1 = new Thread() {
                @Override
                public void run() {
                    try {
                        synchronized (lock) {
                            Print.println("开始    wait time=" + System.currentTimeMillis());
                            lock.wait();
                            Print.println("结束    wait time=" + System.currentTimeMillis());
                        }
                    } catch (InterruptedException e) {
                    }
                }
            };
            thread1.setName("Thread1");
            thread1.start();
            Thread.sleep(3000);
            Thread thread2 = new Thread() {
                @Override
                public void run() {
                    synchronized (lock) {
                        Print.println("开始    notify time=" + System.currentTimeMillis());
                        lock.notify();
                        Print.println("结束    notify time=" + System.currentTimeMillis());

                    }
                }
            };
            thread2.setName("Thread1");
            thread2.start();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}