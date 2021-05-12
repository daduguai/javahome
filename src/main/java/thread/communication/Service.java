package thread.communication;

import utils.Print;

public class Service {
    public void testMethod(Object lock){
        try{
            synchronized (lock){
                Print.println("begin wait() ThreadName="+Thread.currentThread().getName());
                lock.wait();
                //Thread.sleep(40000);
                Print.println("  end wait() ThreadName="+Thread.currentThread().getName());
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    public void synNotifyMethod(Object lock){
        try{
            synchronized (lock){
                Print.println("begin notify() ThreadName="+Thread.currentThread().getName()
                        +" time="+System.currentTimeMillis());
                lock.notify();
                Thread.sleep(5000);
                Print.println("  end notify() ThreadName="+Thread.currentThread().getName()
                        +" time="+System.currentTimeMillis());

            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
