package thread.singleton;

import thread.lock.read_write_lock.ThreadA;

public class FullSingleton extends Singleton {
    private static FullSingleton instance;
    private FullSingleton(){
    }

    public static FullSingleton getInstance(){
        if(instance!=null){
        }else{
            try{
                Thread.sleep(5000);
            }catch (InterruptedException e){}
            instance=new FullSingleton();
        }
        return instance;
    }
}
