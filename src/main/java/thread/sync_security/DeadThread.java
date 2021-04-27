package thread.sync_security;

import utils.Print;

//线程死锁，使用jps，jstack分析
public class DeadThread implements Runnable{
    public String username;
    public Object lock1=new Object();
    public Object lock2=new Object();
    public void setFlag(String username){
        this.username=username;
    }
    public void run(){
        if(username.equals("a")){
            synchronized (lock1){
                try{
                    Print.println("username="+username);
                    Thread.sleep(3000);
                }catch (InterruptedException e ){
                    e.printStackTrace();
                }
                synchronized (lock2){
                    Print.println("按照lock1-->lock2代码顺序执行了");
                }
            }
        }
        if(username.equals("b")){
            synchronized (lock2){
                try{
                    Print.println("username="+username);
                    Thread.sleep(3000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                synchronized (lock1){
                    Print.println("按照lock2-->lock1代码顺序执行了");
                }
            }
        }
    }

    public static  void main(String[] args){
        try{
            DeadThread t1=new DeadThread();
            t1.setFlag("a");
            Thread thread1=new Thread(t1);
            thread1.start();
            Thread.sleep(100);
            t1.setFlag("b");
            Thread  thread2=new Thread(t1);
            thread2.start();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
