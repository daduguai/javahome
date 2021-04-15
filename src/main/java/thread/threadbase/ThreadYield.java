package thread.threadbase;

import utils.Print;

public class ThreadYield extends Thread {
    @Override
    public void run(){
        long start=System.currentTimeMillis();
        Print.println("startTime="+String.valueOf(start));
        int count=0;
        for(int i=0;i<50000000;i++){
            //Thread.currentThread().yield();
            count++;
        }
        long end=System.currentTimeMillis();
        Print.println("endTime="+String.valueOf(end));
        Print.println("执行时间："+String.valueOf(end-start)+"毫秒");
    }

    public static void main(String[] args){
        ThreadYield mythread=new ThreadYield();
        mythread.start();
    }
}
