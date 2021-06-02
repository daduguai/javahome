package thread.lock.multi_producer_consumer;

import utils.Print;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {
    private ReentrantLock lock=new ReentrantLock();
    private Condition condition=lock.newCondition();
    private boolean hasValue=false;

    public void set(){
        try{
            lock.lock();
            Thread.sleep(500);
            while(hasValue==true){
                Print.println("有可能**连续");
                condition.await();
            }
            hasValue=true;
            Print.println("打印*");
            //condition.signalAll();
            condition.signal();//会出现假死
        }catch(InterruptedException e){}finally {
            lock.unlock();
        }
    }

    public void get(){
        try{
            lock.lock();
            while(hasValue==false){
                Print.println("有可能##连续");
                condition.await();
            }
            hasValue=false;
            Print.println("打印#");
            //condition.signalAll();
            condition.signal();//会出现假死
        }catch(InterruptedException e){}finally {
            lock.unlock();
        }
    }
}

//为何出现假死
//唤醒了同类，如生产者唤醒了生产者,那为何会假死
