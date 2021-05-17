package thread.communication.producer_customer;

import thread.communication.wait_notify.ValueObject;
import utils.Print;

public class C {
    private String lock;
    public C(String lock){
        this.lock=lock;
    }

    public void getValue(){
        try{
            synchronized (lock){
                if(ValueObject.value.equals("")){
                    lock.wait();
                }
                Print.println("get的值是："+ValueObject.value);
                ValueObject.value="";
                lock.notify();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
