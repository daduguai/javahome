package thread.lock.producer_cosumer;

import utils.Print;

public class Producer extends Thread {
    private MyService myService;
    public Producer(MyService myService){
        this.myService=myService;
    }
    @Override
    public void run(){
        Print.println("生产者上线：");
        myService.signal();
        Print.println("生产者结束");
    }
}
