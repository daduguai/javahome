package thread.communication;

public class WaitAndNotify3 {
    static class ThreadA extends Thread{
        private Object lock;
        public ThreadA(Object obj){
            super();
            this.lock=obj;
        }
        @Override
        public void run(){
            Service service=new Service();
            service.testMethod(lock);
        }
    }

    static class ThreadB extends Thread{
        private Object lock;
        public ThreadB(Object obj){
            super();
            this.lock=obj;
        }
        @Override
        public void run(){
            Service service=new Service();
            service.testMethod(lock);
        }
    }

    static class NotifyThread extends  Thread{
        private Object lock;
        public NotifyThread(Object lock){
            super();
            this.lock=lock;
        }
        @Override
        public void run(){
            Service service=new Service();
            service.synNotifyMethod(lock);
        }
    }

    static class SynNotifyMethodThread extends  Thread{
        private Object lock;
        public SynNotifyMethodThread(Object lock){
            super();
            this.lock=lock;
        }
        @Override
        public void run(){
            Service service=new Service();
            service.synNotifyMethod(lock);
        }
    }
    public static void main(String[]args){
        Object lock=new Object();
        ThreadA a =new ThreadA(lock);
        a.setName("ThreadA");
        a.start();
        NotifyThread notifyThread=new NotifyThread(lock);
        notifyThread.setName("NotifyThread");
        notifyThread.start();
        SynNotifyMethodThread c=new SynNotifyMethodThread(lock);
        c.setName("SynNotifyMethodThread");
        c.start();
    }
}

//Thread.sleep()不释放锁
//wait()释放锁