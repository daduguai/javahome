package thread.communication.producer_customer;

public class Run {
    public static void main(String[] args){
        String lock=new String("");
        P p=new P(lock);
        C c=new C(lock);
        ThreadP threadP=new ThreadP(p);
        ThreadC threadC=new ThreadC(c);
        threadP.setName("threadP");
        threadC.setName("threadC");
        threadP.start();
        threadC.start();
    }
}
//生产者与消费者