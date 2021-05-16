package thread.communication.producer_customer;

import thread.communication.wait_notify.ValueObject;
import utils.Print;

public class P {
    private String lock;
    public P(String lock){
        this.lock=lock;
    }

    public void setValue(){
        try{
            synchronized (lock){
                if(!ValueObject.value.equals("")){
                    lock.wait();
                }
                String value=System.currentTimeMillis()+"_"+System.nanoTime();
                Print.println("set的值是:"+value);
                ValueObject.value=value;
                lock.notify();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
