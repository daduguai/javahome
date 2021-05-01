package thread.communication;

import utils.Print;
//为什么线程b不打印
public class CommMain {
    public static void main(String[] args){
        MyList service=new MyList();
        ThreadA a=new ThreadA(service);
        a.setName("A");
        a.start();
        ThreadB b=new ThreadB(service);
        b.setName("B");
        b.start();
    }
}
class ThreadA extends Thread{
    private MyList list;
    public ThreadA(MyList list){
        super();
        this.list=list;
    }
    @Override
    public void run(){
        try{
            for(int i=0;i<10;i++){
                list.add();
                Print.println("添加了"+(i+1)+"个元素");
                Thread.sleep(3000);
            }
        }catch (InterruptedException e){}
    }
}
class ThreadB extends Thread{
    private MyList list;
    public ThreadB(MyList list){
        super();
        this.list=list;
    }
    @Override
    public void run(){
        try{
            while(true){
                if(list.size()==5){
                    Print.println("==5,线程b要退出了！");
                    throw new InterruptedException();
                }else{
                    Print.println("线程b.size="+list.size());
                }

            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        Print.println("线程b结束！");
    }
}