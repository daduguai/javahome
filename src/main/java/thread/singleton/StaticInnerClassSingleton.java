package thread.singleton;

public class StaticInnerClassSingleton {
    //private StaticInnerClassSingleton instance;
    //内部类
    private static class MyObjectHandler{
        private static StaticInnerClassSingleton instance=new StaticInnerClassSingleton();
    }
    public static StaticInnerClassSingleton getInstance(){
        return MyObjectHandler.instance;//内部类，可以访问private属性？
    }
}
