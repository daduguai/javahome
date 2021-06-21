package thread.invisibility.happen_before;

public class Run {

    public static void main(String[] args){
        VolatileDemo demo=new VolatileDemo();
        ThreadA A=new ThreadA(demo);
        ThreadB B=new ThreadB(demo);

        B.start();
        try{
            Thread.sleep(1);
        }catch (Exception e){

        }
        A.start();

    }

}
