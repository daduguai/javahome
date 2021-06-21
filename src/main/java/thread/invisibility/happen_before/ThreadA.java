package thread.invisibility.happen_before;

public class ThreadA extends Thread{
    private VolatileDemo demo1;
    public ThreadA(VolatileDemo demo1){
        this.demo1=demo1;
    }
    @Override
    public void run(){
        demo1.writer();
    }
}
