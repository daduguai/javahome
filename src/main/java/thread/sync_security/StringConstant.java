package thread.sync_security;

import utils.Print;

//String常量池，synchronized修饰会遵循同步
public class StringConstant {

    public static void main(String[]args){
        ConstantService service=new ConstantService();
        ConstantThreadA a=new ConstantThreadA(service);
        a.setName("A");
        ConstantThreadB b=new ConstantThreadB(service);
        b.setName("B");
        a.start();
        b.start();
    }
}

class ConstantService{
    public static void print(String str){
        try{
            synchronized (str){
                while(true){
                    Print.println(Thread.currentThread().getName());
                    Thread.sleep(1000);
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
};
class ConstantThreadA extends Thread{
    private ConstantService service;
    public ConstantThreadA(ConstantService service){
        super();
        this.service=service;
    }
    @Override
    public void run(){
        service.print("AA");
    }
};

class ConstantThreadB extends Thread{
    private ConstantService service;
    public ConstantThreadB(ConstantService service){
        super();
        this.service=service;
    }
    @Override
    public void run(){
        service.print("AA");
    }
};