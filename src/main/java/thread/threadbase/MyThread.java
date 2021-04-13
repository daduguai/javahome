package thread.threadbase;

public class MyThread extends Thread{
    @Override
    public void run(){
        super.run();
        try{
            for(int i=0;i<500000;i++){
                System.out.println("i="+(i+1));
                if(this.interrupted()){
                    System.out.println("I was interrupted!");
                    throw new InterruptedException();
                }
            }
            System.out.println("Loop was interrupted,but I can excute");
        }catch(InterruptedException e){
            System.out.println("currentThread="+Thread.currentThread().getName());
        }

    }
}
