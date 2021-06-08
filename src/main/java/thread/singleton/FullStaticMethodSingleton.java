package thread.singleton;

public class FullStaticMethodSingleton {
    private static FullStaticMethodSingleton instance;
    private FullStaticMethodSingleton(){
    }

    public synchronized static FullStaticMethodSingleton getInstance(){
        if(instance!=null){
        }else{
            try{
                Thread.sleep(5000);
            }catch (InterruptedException e){}
            instance=new FullStaticMethodSingleton();
        }
        return instance;
    }
}
