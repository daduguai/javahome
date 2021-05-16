package thread.communication.producer_customer;

import thread.communication.wait_notify.ThreadSubtract;

public class ThreadP extends Thread {
    private P p;
    public ThreadP(P p){
        this.p=p;
    }
    @Override
    public void run(){
        while(true){
            p.setValue();
        }
    }
}
