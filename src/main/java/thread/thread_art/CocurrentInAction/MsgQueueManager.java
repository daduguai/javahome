package thread.thread_art.CocurrentInAction;

import org.apache.kafka.common.protocol.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedTransferQueue;

public class MsgQueueManager implements ImsgQueue {
    private static final Logger LOGGER= LoggerFactory.getLogger(MsgQueueManager.class);

    public final BlockingQueue<Message> messageQueue;
    private MsgQueueManager(){
        messageQueue=new LinkedTransferQueue<Message>();
    }

    public void put(Message msg){
        try{
            messageQueue.put(msg);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
    public Message take(){
        try{
            return messageQueue.take();
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
        return null;
    }
}
