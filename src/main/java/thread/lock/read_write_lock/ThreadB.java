package thread.lock.read_write_lock;

public class ThreadB extends Thread{
    private Service service;
    public ThreadB(Service s){
        super();
        service=s;
    }

    @Override
    public void run(){
        service.read();
    }
}
