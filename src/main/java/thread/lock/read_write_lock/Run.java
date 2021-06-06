package thread.lock.read_write_lock;

public class Run {
    public static void main(String[] args){
        Service service=new Service();
        ThreadA a=new ThreadA(service);
        ThreadA b=new ThreadA(service);
        a.start();
        b.start();

        ThreadC c=new ThreadC(service);
        ThreadD d=new ThreadD(service);
        c.start();
        d.start();
    }
}
