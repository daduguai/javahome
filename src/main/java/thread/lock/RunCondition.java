package thread.lock;

public class RunCondition {
    public static void main(String[] args){
        MyService myService=new MyService();
        ThreadA threadA=new ThreadA(myService);
        threadA.start();
    }
}
