package thread.lock.read_write_lock;

public class ThreadD extends Thread{
    private Service service;
    public ThreadD(Service s){
        super();
        service=s;
    }

    @Override
    public void run(){
        service.write();
    }
}
