package thread.sync_security;

import utils.Print;

import java.util.concurrent.Callable;

public class VolatileTest2 implements Runnable {
    private boolean continuePrint=true;
    public  boolean isContinuePrint(){
        return continuePrint;
    }

    public void setContinuePrint(boolean isContinue){
        continuePrint=isContinue;
    }

    public void printStringMethod(){
        try{
            while(continuePrint){
                Print.println("run printStringMethod threadName="+Thread.currentThread().getName());
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){}
    }

    public void run(){
        printStringMethod();
    }

    public static void main(String[] args){
        VolatileTest2 vt2=new VolatileTest2();
        new Thread(vt2).start();
        Print.println("我要停止它！stopThread="+Thread.currentThread().getName());
        vt2.setContinuePrint(false);
    }
}