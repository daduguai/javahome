package thread.singleton;

public class FullStaticMethodSingleton {
    private volatile static FullStaticMethodSingleton instance;//volatile防止指令重排，内存可见性
    private FullStaticMethodSingleton(){
    }

    public synchronized static FullStaticMethodSingleton getInstance(){
        if(instance!=null){
        }else{
            try{
                Thread.sleep(5000);
                instance=new FullStaticMethodSingleton();
            }catch (InterruptedException e){}

        }
        return instance;
    }
}
