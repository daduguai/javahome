package thread.threadlocal;

import utils.Print;

import java.util.Date;

public class ThreadADate extends  Thread {
    @Override
    public void run(){
        try{
            for(int i=0;i<20;i++){
                if(Tools.t2.get()==null){
                    Tools.t2.set(new Date());
                }
                Print.println("A "+Tools.t2.get().getTime());
                Thread.sleep(100);
            }
        }catch (InterruptedException e){}
    }
}
