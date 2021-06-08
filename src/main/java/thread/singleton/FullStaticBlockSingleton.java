package thread.singleton;

public class FullStaticBlockSingleton {
    private static FullStaticBlockSingleton instance;
    private FullStaticBlockSingleton(){
    }
    static{
        instance=new FullStaticBlockSingleton();
    }
    public static FullStaticBlockSingleton getInstance(){
        return instance;
    }
}
