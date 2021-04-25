package thread.sync_security;

import utils.Print;
//对象锁与class锁并非同一把锁，不遵循同步
public class SyncStatic {
    public static void main(String[] args){
        final MyService service=new MyService();
        Thread a=new Thread(){
            @Override
            public void run(){
                service.printA();
            }
        };
        Thread b=new Thread(){
            @Override
            public void run(){
                service.printB();
            }
        };
        Thread c=new Thread(){
            @Override
            public void run(){
                service.printC();
            }
        };
        Thread d=new Thread(){
            @Override
            public void run(){
                service.printD();
            }
        };

        a.setName("A");
        b.setName("B");
        c.setName("C");
        d.setName("D");
        a.start();
        b.start();
        c.start();
        d.start();
    }
}

class MyService {
    synchronized  public static void printA(){
        try{
            Print.println("printA进入 time="+System.currentTimeMillis()+" run ThreadName="+Thread.currentThread().getName());
            Thread.sleep(3000);
            Print.println("printA退出 time="+System.currentTimeMillis()+" run ThreadName="+Thread.currentThread().getName());
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    synchronized public static void printB(){
        try{
            Print.println("printB进入 time="+System.currentTimeMillis()+" run ThreadName="+Thread.currentThread().getName());
            Thread.sleep(3000);
            Print.println("printB退出 time="+System.currentTimeMillis()+" run ThreadName="+Thread.currentThread().getName());
        }catch(InterruptedException e){

        }

    }
    synchronized public void printC(){
        try{
            Print.println("printC进入 time="+System.currentTimeMillis()+" run ThreadName="+Thread.currentThread().getName());
            Thread.sleep(3000);
            Print.println("printC退出 time="+System.currentTimeMillis()+" run ThreadName="+Thread.currentThread().getName());
        }catch(InterruptedException e){}

    }

    public void printD(){
        try{
            Print.println("printD进入 time="+System.currentTimeMillis()+" run ThreadName="+Thread.currentThread().getName());
            Thread.sleep(3000);
            Print.println("printD退出 time="+System.currentTimeMillis()+" run ThreadName="+Thread.currentThread().getName());
        }catch(InterruptedException e){}

    }
}
