package thread.lock.read_write_lock;

public class ThreadC extends Thread{
    private Service service;
    public ThreadC(Service s){
        super();
        service=s;
    }

    @Override
    public void run(){
        service.write();
    }
}
