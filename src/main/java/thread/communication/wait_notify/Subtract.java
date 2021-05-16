package thread.communication.wait_notify;

import utils.Print;

public class Subtract {
    private String lock;
    public Subtract(String lock){
        super();
        this.lock=lock;
    }

    public void subtract(){
        try{
            synchronized (lock){
                if(ValueObject.list.size()==0){
                    Print.println("wait begin ThreadName="+Thread.currentThread().getName());
                    lock.wait();
                    Print.println("wait   end ThreadName="+Thread.currentThread().getName());
                }
                ValueObject.list.remove(0);
                Print.println("list size="+ValueObject.list.size());
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
