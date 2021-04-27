package thread.sync_security;

import utils.Print;

public class Run1 {
    private String lock="123";
    public void testMethod(){
        try{
            synchronized (lock){
                Print.println(Thread.currentThread().getName()+" begin "+System.currentTimeMillis());
                lock="456";
                Thread.sleep(2000);
                Print.println(Thread.currentThread().getName()+" end   "+System.currentTimeMillis());
            }
        }catch(InterruptedException e){}
    }
//    class ThreadAA extends Thread{
//        private Run1 run;
//        public ThreadAA(Run1 run2){
//            super();
//            run=run2;
//        }
//        @Override
//        public void run(){
//            run.testMethod();
//        }
//    }
//
//    class ThreadBB extends Thread{
//        private Run1 run;
//        public ThreadBB(Run1 run2){
//            super();
//            run=run2;
//        }
//        @Override
//        public void run(){
//            run.testMethod();
//        }
//    }
    public static void main(String[] args){
        try{
            Run1 run1=new Run1();
            ThreadAA a=new ThreadAA(run1);
            a.setName("A");
            ThreadBB b=new ThreadBB(run1);
            b.setName("B");
            a.start();
            Thread.sleep(50);
            b.start();
        }catch(InterruptedException e){}

    }
}
class ThreadAA extends Thread{
    private Run1 run;
    public ThreadAA(Run1 run2){
        super();
        run=run2;
    }
    @Override
    public void run(){
        run.testMethod();
    }
}

class ThreadBB extends Thread{
    private Run1 run;
    public ThreadBB(Run1 run2){
        super();
        run=run2;
    }
    @Override
    public void run(){
        run.testMethod();
    }
}

//如果锁定的对象变化了，则拿的非同一把锁