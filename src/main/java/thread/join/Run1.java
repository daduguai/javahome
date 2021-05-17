package thread.join;

import utils.Print;

public class Run1 {
    public static void main(String[] args){
        try{
            ThreadB b=new ThreadB();
            ThreadA a=new ThreadA(b);
            a.start();
            b.start();
            b.join(2000);
            Print.println("Main end ThreadName="+"  "+System.currentTimeMillis());
        }catch (InterruptedException e){}
    }
}
//join使用wait实现，释放锁，sleep占用锁