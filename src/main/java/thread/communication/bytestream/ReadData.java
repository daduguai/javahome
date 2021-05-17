package thread.communication.bytestream;

import utils.Print;

import java.io.IOException;
import java.io.PipedInputStream;

public class ReadData {
    public void readMethod(PipedInputStream input){
        try{
            Print.println("read :");
            byte[] byteArray=new byte[20];
            int readLength=input.read(byteArray);
            while(readLength!=-1){
                String newDate=new String(byteArray,0,readLength);
                Print.println(newDate);
                readLength=input.read(byteArray);
            }
            input.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
