package thread.thread_art.thread_base;

import java.util.concurrent.TimeUnit;

public class SleepUtils {
    public static final void second(long seconds){
        try{
            TimeUnit.SECONDS.sleep(seconds);
        }catch(InterruptedException e){

        }
    }
}
