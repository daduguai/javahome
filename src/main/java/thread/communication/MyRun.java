package thread.communication;

import utils.Print;

public class MyRun {
    private String lock = new String("");
    private Runnable runnableA = new Runnable() {
        public void run() {
            try {
                synchronized (lock) {
                    Print.println("begin wait");
                    lock.wait();
                    Print.println("end wait");
                }
            } catch (InterruptedException e) {
            }
        }
    };
    private Runnable runnableB = new Runnable() {
        public void run() {
            synchronized (lock) {
                Print.println("begin notify");
                lock.notify();
                Print.println("  end notify");
            }
        }
    };

    //    public static void main(String[] args){
//        MyRun run=new MyRun();
//        Thread a = new Thread(run.runnableA);
//        a.start();
//        Thread b=new Thread(run.runnableB);
//        b.start();
//    }
    public static void main(String[] args) {
        MyRun run = new MyRun();
        Thread a = new Thread(run.runnableB);
        a.start();
        Thread b = new Thread(run.runnableA);
        b.start();
    }
}
