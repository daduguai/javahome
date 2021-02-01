package thread.timer;

import utils.Print;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class RunInFuture {
    private static Timer timer=new Timer(true);
    static public class MyTask extends TimerTask {
        @Override
        public void run(){
            Print.println("运行了！时间为:"+new Date());
        }
    }

    public static void main(String[] args){
        try{
            MyTask task=new MyTask();
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateString="2021-06-07 07:09:00";
            Date dateRef=sdf.parse(dateString);
            Print.println("字符串时间:"+dateRef.toLocaleString()+" 当前时间:"+new Date().toLocaleString());
            timer.schedule(task,dateRef);
            Thread.sleep(2000);
        }catch(ParseException e){

        }catch (InterruptedException e){

        }
    }
}
