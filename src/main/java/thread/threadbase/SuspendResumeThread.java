package thread.threadbase;

import utils.Print;

//线程的暂停与继续执行suspend and resume
public class SuspendResumeThread extends Thread {
    private long i = 0;

    public long getI() {
        return i;
    }

    public void setI(long i) {
        this.i = i;
    }

    @Override
    public void run() {
        while (true) {
            i++;
        }
    }

    public static void main(String[] args) {
        SuspendResumeThread thread = new SuspendResumeThread();
        thread.start();
        try {
            Thread.sleep(5000);
            thread.suspend();
            Print.println("A=" + System.currentTimeMillis() + "i=" + thread.getId());
            Thread.sleep(5000);
            thread.resume();
            Print.println("B=" + System.currentTimeMillis() + "i=" + thread.getId());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
