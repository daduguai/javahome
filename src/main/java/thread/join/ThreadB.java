package thread.join;

import utils.Print;

public class ThreadB extends Thread {
    @Override
    synchronized public void run(){
        try{
            Print.println("begin B ThreadName="+Thread.currentThread().getName()+"  "+System.currentTimeMillis());
            Thread.sleep(5000);
            Print.println("  end B ThreadName="+Thread.currentThread().getName()+"  "+System.currentTimeMillis());
        }catch (InterruptedException e){}
    }
}
