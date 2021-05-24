package thread.threadlocal;

import utils.Print;

public class ThreadAExt extends Thread {
    @Override
    public void run(){
        try{
            for(int i=0;i<10;i++){
                Print.println("在ThreadAExt线程中取值="+Tools.t3.get());
                Thread.sleep(100);
            }
        }catch(InterruptedException e){}
    }
}
