package thread.invisibility.happen_before;

public class ThreadB extends Thread{
    private VolatileDemo demo1;
    public ThreadB(VolatileDemo demo1){
        this.demo1=demo1;
    }

    @Override
    public void run(){
        demo1.reader();
    }
}
