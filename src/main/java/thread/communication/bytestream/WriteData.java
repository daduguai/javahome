package thread.communication.bytestream;

import utils.Print;

import java.io.IOException;
import java.io.PipedOutputStream;

public class WriteData {
    public void writeMethod(PipedOutputStream out){
        try{
            Print.println("write:");
            for(int i=0;i<300;i++){
                String outDate=""+(i+1);
                out.write(outDate.getBytes());
                Thread.sleep(2000);
                Print.println(outDate);
            }
            out.close();
        }catch (IOException e){
            e.printStackTrace();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
