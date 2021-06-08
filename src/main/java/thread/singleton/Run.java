package thread.singleton;

public class Run {
    public static void main(String[] args){
        //Singleton singleton=HungrySingleton.getInstance();//饿汉
//        Singleton singleton1=FullSingleton.getInstance();//
//        Singleton singleton2=FullSingleton.getInstance();
//        Singleton singleton3=FullSingleton.getInstance();
        MyThread t1=new MyThread();
        MyThread t2=new MyThread();
        MyThread t3=new MyThread();
        t1.start();
        t2.start();
        t3.start();
    }
}
