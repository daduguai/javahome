package thread.threadlocal;

public class RunDate {
    public static void main(String[] args){
        try{
            ThreadADate a=new ThreadADate();
            a.start();
            Thread.sleep(1000);
            ThreadBDate b=new ThreadBDate();
            b.start();
        }catch (InterruptedException e){}
    }
}
