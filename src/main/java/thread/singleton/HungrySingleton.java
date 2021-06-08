package thread.singleton;

//饿汉模式
public class HungrySingleton extends Singleton{
    private static HungrySingleton instance=new HungrySingleton();
    private HungrySingleton(){}
    public static HungrySingleton getInstance(){
        return instance;
    }
}
