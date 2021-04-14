package thread.threadbase;

public class MyThreadInSleep extends Thread{
    @Override
    public void run(){
        super.run();
        try{
            System.out.println("I was asleep");
            Thread.sleep(20000);
            System.out.println("I was awake");
        }catch(InterruptedException e){
            e.printStackTrace();
            System.out.println("InterruptedException,currentThread="+Thread.currentThread().getName()+",I was waked");
        }

    }
}
