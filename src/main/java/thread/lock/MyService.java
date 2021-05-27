package thread.lock;

import utils.Print;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {
    private Lock lock=new ReentrantLock();
    private Condition condition=lock.newCondition();
    public void testMethod(){
        lock.lock();
        for(int i=0;i<5;i++){
            Print.println("ThreadName="+Thread.currentThread().getName()+" "+(i+1));
        }
        lock.unlock();
    }

    public void await(){
        try {
            lock.lock();
            Print.println("A");
            condition.await();
            Print.println("B");
        }catch (InterruptedException e){

        }finally {
            lock.unlock();
            Print.println("锁释放了！");
        }
    }
}
