package thread.communication;

import utils.Print;

public class Test1 {
    //    public static void main(String[] args){
//        try{
//            String newString=new String("");
//            newString.wait();
//        }catch(InterruptedException e){}
//    }
    public static void main(String[] args) {
        try {
            String newString = new String();
            Print.println("syn上面");
            synchronized (newString){
                Print.println("syn第一行");
                newString.wait();
                Print.println("wait下的代码");
            }
            Print.println("syn下面的代码");
            newString.wait();
        } catch (InterruptedException e) {
        }
    }
}
//wait需要在同步代码块中