package thread.lock.read_write_lock;

public class ThreadA extends Thread{
    private Service service;
    public ThreadA(Service s){
        super();
        service=s;
    }

    @Override
    public void run(){
        service.read();
    }
}
