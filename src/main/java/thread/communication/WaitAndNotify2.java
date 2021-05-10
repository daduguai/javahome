package thread.communication;

import utils.Print;

public class WaitAndNotify2 {
    public static void main(String[] args) {
        try {
            final MyList myList = new MyList();
            final Object lock = new Object();
            Thread a = new Thread() {
                @Override
                public void run() {
                    try {
                        synchronized (lock){
                            Print.println("wait begin " + System.currentTimeMillis());
                            if (myList.size() != 5) {
                                lock.wait();
                            }
                            Print.println("wait end " + System.currentTimeMillis());
                        }
                    } catch (InterruptedException e) {
                    }
                }
            };
            a.setName("a");
            a.start();
            Thread.sleep(1000);
            Thread b = new Thread() {
                @Override
                public void run() {
                    try {
                        synchronized (lock){
                            for (int i = 0; i <10;i++){
                                myList.add();
                                if(myList.size()==5){
                                    lock.notify();
                                    Print.println("b已经发出唤醒通知");
                                    break;
                                }
                                Print.println("添加了："+(i+1)+" 个元素");
                                Thread.sleep(1000);
                            }
                        }
                        Thread.sleep(5000);
                        Print.println("Thread name="+Thread.currentThread().getName()+" end");
                    } catch (InterruptedException e) {
                    }
                }
            };
            b.setName("b");
            b.start();

        } catch (InterruptedException e) {
        }
    }
}

//wait需要等notify线程结束后再执行,并非如此，需要看synchronized是否获取到锁
