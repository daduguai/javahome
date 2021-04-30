package thread.sync_security;

import utils.Print;
//原子类自增的使用
import java.util.concurrent.atomic.AtomicInteger;

public class AddCountThread extends Thread{
    private AtomicInteger count=new AtomicInteger(0);

    private volatile long sumTime=0;

    @Override
    public void run(){
        long start=System.currentTimeMillis();
        for(int i=0;i<10;i++){
            Print.println(count.incrementAndGet());
        }
        long end=System.currentTimeMillis();
        long lastTime=(end-start)/1000;
        sumTime=sumTime+lastTime;
        Print.println("currentThread Name="+Thread.currentThread().getName()+" last time="+sumTime);
    }

    public static void main(String[]args){
        AddCountThread countService=new AddCountThread();
        Thread t1=new Thread(countService);
        t1.setName("t1");
        t1.start();
        Thread t2=new Thread(countService);
        t2.setName("t2");
        t2.start();
//        Thread t3=new Thread(countService);
//        t3.setName("t3");
//        t3.start();
//        Thread t4=new Thread(countService);
//        t4.setName("t4");
//        t4.start();
//        Thread t5=new Thread(countService);
//        t5.setName("t5");
//        t5.start();
    }
}
