package thread.singleton;

import utils.Print;

public class MyThread extends Thread{
    //private Singleton singleton;
    public MyThread(){
    }
    @Override
    public void run(){
        Print.println(StaticInnerClassSingleton.getInstance().hashCode());
    }
}
