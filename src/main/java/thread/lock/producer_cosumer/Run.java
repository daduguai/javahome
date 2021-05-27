package thread.lock.producer_cosumer;

public class Run {
    public static void main(String[] args){
        MyService myService=new MyService();
        Consumer consumer=new Consumer(myService);
        Producer producer=new Producer(myService);

        producer.start();
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){}finally {

        }

        consumer.start();

    }
}
