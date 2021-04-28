package thread.sync_security;

import utils.Print;

public class VolatileTest {
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

    public static void main(String[] args){
        final VolatileTest vt=new VolatileTest();
        Thread th=new Thread(){
            @Override
            public void run(){
                vt.printStringMethod();
            }
        };
        th.start();
        Print.println("我要停止它！stopThread="+Thread.currentThread().getName());
        vt.setContinuePrint(false);
    }
}
//并不会出现无限循环，即使没有加volatile，也没出现死循环