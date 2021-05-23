package thread.threadlocal;

import utils.Print;

public class ThreadB extends Thread{
    @Override
    public void run(){
        try{
            for(int i=0;i<100;i++){
                Tools.t1.set("ThreadB"+(i+1));
                Print.println("ThreadB get Value="+ Tools.t1.get());
                Thread.sleep(200);
            }
        }catch(InterruptedException e){}
    }
}
