package thread.join;

import utils.Print;

public class ThreadA extends Thread{
    private ThreadB b;
    public ThreadA(ThreadB b){
        super();
        this.b=b;
    }
    @Override
    public void run(){
        try{
            synchronized (b){
                Print.println("begin A ThreadName="+Thread.currentThread().getName()+"  "+System.currentTimeMillis());
                Thread.sleep(5000);
                Print.println("  end A ThreadName="+Thread.currentThread().getName()+"  "+System.currentTimeMillis());
            }
        }catch (InterruptedException e){}
    }
}
