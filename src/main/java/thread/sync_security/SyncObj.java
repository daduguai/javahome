package thread.sync_security;

import utils.Print;
//多线程访问呢同一个对象的不同加了synchronized 方法也遵循同步，非synchronizied则无需遵循同步
public class SyncObj {
    synchronized public void methodA(){
        try{
            Print.println("begin methodA threadName="+Thread.currentThread().getName());
            Thread.sleep(5000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        Print.println("end methodA threadName="+Thread.currentThread().getName());
    }

    synchronized public void methodB(){
        try{
            Print.println("begin methodB threadName="+Thread.currentThread().getName());
            Thread.sleep(5000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        Print.println("end methodB threadName="+Thread.currentThread().getName());
    }

    public static void main(String[] args){
        final SyncObj obj=new SyncObj();
        Thread threadA=new Thread(){
            @Override
            public void run(){
                obj.methodA();
            }
        };
        threadA.setName("A");

        Thread threadB=new Thread(){
            @Override
            public void run(){
                obj.methodB();
            }
        };
        threadB.setName("B");

        threadA.start();
        threadB.start();
    }
}
