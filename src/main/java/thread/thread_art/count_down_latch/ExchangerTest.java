package thread.thread_art.count_down_latch;

import utils.Print;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExchangerTest {
    private static final Exchanger<String>exgr=new Exchanger<String>();
    private static ExecutorService threadPool =Executors.newFixedThreadPool(2);
    public static void main(String[] args){
        threadPool.execute(new Runnable(){
            @Override
            public void run(){
                try{
                    String A="银行流水A";
                    exgr.exchange(A);
                }catch (InterruptedException e){

                }
            }
        });
        threadPool.execute(new Runnable(){
            @Override
            public void run(){
                try{
                    String B="银行流水B";
                    String A=exgr.exchange("B");
                    Print.println("A和B数据是否一致："+A.equals(B)+",A录入的是："+A+",B录入的是:"+B);
                }catch(InterruptedException e){}
            }
        });
        threadPool.shutdown();
    }

}
