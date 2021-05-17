package thread.communication.bytestream;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Run {
    public static void main(String[] args){
        try{
            WriteData writeData=new WriteData();
            ReadData readData=new ReadData();

            PipedInputStream inputStream=new PipedInputStream();
            PipedOutputStream outStream=new PipedOutputStream();

            outStream.connect(inputStream);

            ThreadRead threadRead=new ThreadRead(readData,inputStream);
            threadRead.start();

            Thread.sleep(2000);

            ThreadWrite threadWrite=new ThreadWrite(writeData,outStream);
            threadWrite.start();

        }catch (IOException e){
        }catch (InterruptedException e){
        }
    }
}
