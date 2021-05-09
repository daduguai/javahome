package thread.communication;

import utils.Print;

public class WaitAndNotifying {
    public static void main(String[] args){
        try{
            String lock= new String();

            synchronized (lock){
                Print.println("syn第一行");
                lock.wait();
                Print.println("wait下的代码");
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
