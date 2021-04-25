package thread.sync_security;

import utils.Print;

//
public class SyncDifferentMethod {
    public static void main(String[] args){
        MyObject myObject=new MyObject();
        Service service=new Service();
        Thread a=new ThreadA(service,myObject);
        a.setName("ThreadA");
        Thread b=new ThreadB(myObject);
        b.setName("ThreadB");
        a.start();
        b.start();
    }
}

class MyObject{
    synchronized public void speedPrintString(){
        Print.println("speedPrintString __getLock time="+System.currentTimeMillis()+" run ThreadName="+Thread.currentThread().getName());
        Print.println("-----------------------------------");
        Print.println("speedPrintString __releaseLock time="+System.currentTimeMillis()+" run ThreadName="+Thread.currentThread().getName());


    }
}

class Service{
    public void testMethod1(MyObject object){
        synchronized (object){
            try{
                Print.println("testMethod1 __getLock time="+System.currentTimeMillis()+" run ThreadName="+Thread.currentThread().getName());
                Thread.sleep(5000);
                Print.println("testMethod1 __releaseLock time="+System.currentTimeMillis()+" run ThreadName="+Thread.currentThread().getName());

            }catch(InterruptedException e){}
        }
    }
}

class ThreadA extends Thread{
    private Service service;
    private MyObject myObject;

    public ThreadA(Service service,MyObject myObject){
        this.myObject=myObject;
        this.service=service;
    }
    @Override
    public void run(){
        service.testMethod1(myObject);
    }
}

class ThreadB extends Thread{
    private MyObject myObject;

    public ThreadB(MyObject myObject){
        this.myObject=myObject;
    }
    @Override
    public void run(){
        myObject.speedPrintString();
    }
}