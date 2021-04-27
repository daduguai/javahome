package thread.sync_security;

import utils.Print;

public class OutClass2 {
    static class InnerClass1 {
        public void method1(InnerClass2 class2) {
            String threadName = Thread.currentThread().getName();
            synchronized (class2) {
                Print.println(threadName + " 进入InnerClass1中的method1方法");
                for (int i = 0; i < 5; i++) {
                    Print.println("i=" + i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                    }
                }
                Print.println(threadName + " 离开InnerClass1中的method1方法");
            }
        }

        public synchronized void method2() {
            String threadName = Thread.currentThread().getName();
            Print.println(threadName + " 进入InnerClass1中的method2方法");
            for (int i = 0; i < 5; i++) {
                Print.println("j=" + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
            }
            Print.println(threadName + " 离开InnerClass1中的method2方法");
        }

    }

    static class InnerClass2 {
        public synchronized void method1() {
            String threadName = Thread.currentThread().getName();
            Print.println(threadName + " 进入InnerClass2中的method1方法");
            for (int i = 0; i < 5; i++) {
                Print.println("k=" + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
            }
            Print.println(threadName + " 离开InnerClass2中的method1方法");
        }
    }

    public static  void main(String[] args){
        final InnerClass1 in1=new InnerClass1();
        final InnerClass2 in2=new InnerClass2();
        Thread t1=new Thread(new Runnable() {
            public void run() {
                in1.method1(in2);
            }
        },"T1");

        Thread t2=new Thread(new Runnable() {
            public void run() {
                in1.method2();
            }
        },"T2");

        Thread t3=new Thread(new Runnable() {
            public void run() {
                in2.method1();
            }
        },"T3");

        t1.start();
        t2.start();
        t3.start();
    }
}
