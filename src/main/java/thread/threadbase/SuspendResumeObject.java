package thread.threadbase;

import utils.Print;
//suspend resume的独占性
public class SuspendResumeObject {
    synchronized public void printString(){
        Print.println("begin");
        if(Thread.currentThread().getName().equals("a")){
            Print.println("a线程永远suspend了");
            Thread.currentThread().suspend();
        }
        Print.println("end");
    }

    public static void main(String[] args){
        try{
            final SuspendResumeObject object=new SuspendResumeObject();
            Thread thread1=new Thread(){
                @Override
                public void run(){
                    object.printString();
                }
            };
            thread1.setName("a");
            thread1.start();
            Thread.sleep(1000);
            Thread thread2=new Thread(){
                @Override
                public void run(){
                    Print.println("thread2 启动了，但进入不了printString()方法");
                    Print.println("因为printString()被a线程锁定并被suspend了");
                    object.printString();
                }
            };
            thread2.start();
            //thread1.resume();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
