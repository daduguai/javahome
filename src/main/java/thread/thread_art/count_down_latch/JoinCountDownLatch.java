package thread.thread_art.count_down_latch;

import utils.Print;

//等待多个线程执行结束，汇总结果
public class JoinCountDownLatch {
    public static void main(String[] args){
        try{
            Thread parser1=new Thread(new Runnable(){
                @Override
                public void run(){
                    try{
                        Thread.sleep(5000);
                    }catch (InterruptedException e){
                    }

                }
            });
            Thread parser2=new Thread(new Runnable(){
                @Override
                public void run(){
                    Print.println("parser2 finish");
                }
            });
            parser1.start();
            parser2.start();
            parser1.join();
            parser2.join();
            Print.println("all parser finish");
        }catch(InterruptedException e){}

    }
}
