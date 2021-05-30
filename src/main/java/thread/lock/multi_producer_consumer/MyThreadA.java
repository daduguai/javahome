package thread.lock.multi_producer_consumer;

import thread.lock.MyThread;

public class MyThreadA extends Thread {
    private MyService myService;
    public MyThreadA(MyService myService){
        super();
        this.myService=myService;
    }

    @Override
    public void run(){
        for(int i=0;i<Integer.MAX_VALUE;i++){
            myService.get();
        }
    }
}
