package thread.threadlocal;

import utils.Print;

public class RunExt {
    public static void main(String[] args){
        try{
            for(int i=0;i<10;i++){
                Print.println("在Main线程中取值="+Tools.t3.get());
                Thread.sleep(100);
            }
            Thread.sleep(5000);
            ThreadAExt a=new ThreadAExt();
            a.start();
        }catch (InterruptedException e){}
    }
}
