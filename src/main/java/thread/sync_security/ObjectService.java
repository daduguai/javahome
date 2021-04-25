package thread.sync_security;

import utils.Print;

//同一个对象的不同的synchronized代码块遵循同步
public class ObjectService {
    public void serviceMethodA(){
        try{
            synchronized (this){
                Print.println("A begin time="+System.currentTimeMillis());
                Thread.sleep(2000);
                Print.println("A end time="+System.currentTimeMillis());
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    public void serviceMethodB(){
        synchronized (this){
            Print.println("B begin time="+System.currentTimeMillis());
            Print.println("B end time="+System.currentTimeMillis());
        }
    }

    public static void main(String[]args){
        final ObjectService srv=new ObjectService();
        Thread A=new Thread(){
            @Override
            public void run(){
                srv.serviceMethodA();
            }
        };
        Thread B=new Thread(){
            @Override
            public void run(){
                srv.serviceMethodB();
            }
        };
        A.start();
        B.start();
    }
}
