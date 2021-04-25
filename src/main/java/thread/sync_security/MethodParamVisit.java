package thread.sync_security;

import utils.Print;

//方法内变量是线程安全的，实例变量非线程安全
public class MethodParamVisit {
    int num=0;
    public void setNum(String userName){
        try{
            //int num=0;
            if(userName.equals("a")){
                num=100;
                Print.println(Thread.currentThread().getName()+","+"a set over");
                Thread.sleep(2000);
            }else{
                num=200;
                Print.println(Thread.currentThread().getName()+","+"other set over");
            }
            Print.println(userName+",num="+num);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        final MethodParamVisit visit=new MethodParamVisit();
        Thread thread1=new Thread(){
            @Override
            public void run(){
                visit.setNum("a");
            }
        };
        thread1.start();
        Thread thread2=new Thread(){
            @Override
            public void run(){
                visit.setNum("b");
            }
        };
        thread2.start();
    }
}
