package thread.lock.producer_cosumer;

import utils.Print;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {
    private Lock lock=new ReentrantLock();
    private Condition condition=lock.newCondition();
    public void await(){
        try{
            lock.lock();
            Print.println("await 时间为："+System.currentTimeMillis());
            condition.await();
        }catch (InterruptedException e){}finally {
            lock.unlock();
        }
    }

    public void signal(){
        try{
            lock.lock();
            Print.println("signal 时间为："+System.currentTimeMillis());
            condition.signal();
        }finally {
            lock.unlock();
        }
    }
}
