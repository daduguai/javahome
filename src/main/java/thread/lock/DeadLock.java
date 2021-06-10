package thread.lock;

import utils.Print;

public class DeadLock {
    private static Object resource1 = new Object();
    private static Object resource2 = new Object();

    public static void main(String[] args) {
        new Thread("线程1"){
            @Override
            public void run(){
                synchronized (resource1){
                    Print.println(Thread.currentThread()+"get resource1");
                    try{
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    Print.println(Thread.currentThread()+"waiting get resource2");
                    synchronized (resource2){
                        Print.println(Thread.currentThread()+"get resource2");
                    }
                }
            }
        }.start();

        new Thread("线程2"){
            @Override
            public void run(){
                synchronized (resource2){
                    Print.println(Thread.currentThread()+"get resource2");
                    try{
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    Print.println(Thread.currentThread()+"waiting get resource1");
                    synchronized (resource1){
                        Print.println(Thread.currentThread()+"get resource1");
                    }
                }
            }
        }.start();
    }
}
