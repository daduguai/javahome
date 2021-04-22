package thread.sync_security;

import utils.Print;

//同一个对象的不同的synchronized代码块遵循同步，
// 同一个对象的同步代码块和同步方法之间也同步(前提是是使用了同一个对象监视器)
public class ObjectService2 {
    synchronized public void serviceMethodA() {
        try {
            Print.println("A begin time=" + System.currentTimeMillis());
            Thread.sleep(2000);
            Print.println("A end time=" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void serviceMethodB() {
        String anyString="";
        synchronized (anyString) {//若将this换成了局部变量，则非一个对象监视器
            Print.println("B begin time=" + System.currentTimeMillis());
            Print.println("B end time=" + System.currentTimeMillis());
        }
    }

    public static void main(String[] args) {
        final ObjectService2 srv = new ObjectService2();
        Thread A = new Thread() {
            @Override
            public void run() {
                srv.serviceMethodA();
            }
        };
        Thread B = new Thread() {
            @Override
            public void run() {
                srv.serviceMethodB();
            }
        };
        A.start();
        B.start();
    }
}
