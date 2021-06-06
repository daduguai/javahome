package thread.lock.read_write_lock;

import utils.Print;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Service {
    private ReentrantReadWriteLock lock=new ReentrantReadWriteLock();
    public void read(){
        try{
            lock.readLock().lock();
            Print.println("获取读锁"+Thread.currentThread().getName()+"  "+System.currentTimeMillis());
            Thread.sleep(5000);
        }catch(InterruptedException e){

        }finally {
            lock.readLock().unlock();
        }
    }

    public void write(){
        try{
            lock.writeLock().lock();
            Print.println("获取写锁"+Thread.currentThread().getName()+"  "+System.currentTimeMillis());
            Thread.sleep(5000);
        }catch(InterruptedException e){

        }finally {
            lock.writeLock().unlock();
        }
    }
}
