package thread.threadbase;

public class ThreadMain {
//    public static void main(String[]args){
//        try{
//            MyThread thread=new MyThread();
//            thread.start();
//            Thread.sleep(1000);
//            thread.interrupt();
//            System.out.println("是否停止1？="+thread.interrupted());
//            System.out.println("是否停止2？="+thread.isInterrupted());
//        }catch(InterruptedException e){
//            System.out.println("main catch");
//            e.printStackTrace();
//        }
//        System.out.println("end!");
//    }

//    //Thread.interrupted()具有清除中断的作用
//    public static void main(String[] args) {
//        Thread mythread=new MyThread();
//        mythread.setName("mythread-1");
//        mythread.start();
//        try{
//            Thread.sleep(1000);
//        }catch(InterruptedException e){
//            e.printStackTrace();
//        }
//        mythread.interrupt();
//        Thread.currentThread().interrupt();
//        System.out.println("是否停止1？=" + Thread.interrupted());//True
//        System.out.println("是否停止2？=" + Thread.interrupted());//False
//        System.out.println("end!");
//    }

    //子线程在睡眠中，被主线程interrupt
    public static void main(String[] asgs){
        System.out.println("main thread start");
        Thread thread=new MyThreadInSleep();
        thread.start();
        thread.interrupt();
        System.out.println("main thread end");
    }
}

