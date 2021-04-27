package thread.sync_security;

import utils.Print;

//内部类不同synchronized方法持有不同的锁，同样遵循同步
public class OutClass {
    static class Inner{
        public synchronized void method1(){
             for(int i=1;i<10;i++){
                 Print.println(Thread.currentThread().getName()+"  i="+i);
                 try{
                     Thread.sleep(1000);
                 }catch (InterruptedException e){}
             }
        }
        public  void method2(){
            synchronized("其他锁"){
                for(int i=11;i<20;i++){
                    Print.println(Thread.currentThread().getName()+"  i="+i);
                    try{
                        Thread.sleep(100);
                    }catch (InterruptedException e){}
                }
            }
        }
    }
    public static void main(String[] args){
        final Inner inner=new Inner();
        Thread t1=new Thread(){
            @Override
            public void run(){
                inner.method1();
            }
        };
        t1.setName("A");
        Thread t2=new Thread(){
            @Override
            public void run(){
                inner.method2();
            }
        };
        t2.setName("B");
        t1.start();
        t2.start();
    }
}
