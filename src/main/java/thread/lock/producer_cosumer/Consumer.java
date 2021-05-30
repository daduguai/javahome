package thread.lock.producer_cosumer;

import thread.lock.ThreadA;
import utils.Print;

import java.util.concurrent.locks.Condition;

public class Consumer extends Thread {
    private MyService myService;
    public Consumer(MyService myService){
        this.myService=myService;
    }
    @Override
    public void run(){
        Print.println("消费者上线：");
        myService.await();
        Print.println("消费者消费结束");
    }
}
