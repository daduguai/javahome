package thread.thread_art.count_down_latch;

import utils.Print;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
    static CyclicBarrier c=new CyclicBarrier(2);
    public static void main(String[]args){
        new Thread(new Runnable(){
            public void run(){
                try{
                    c.await();
                }catch(Exception e){

                }
                Print.println(1);
            }
        }).start();
        try {
            c.await();
        }catch (Exception e){}
        Print.println(2);
    }
}
