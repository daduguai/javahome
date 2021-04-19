package kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import utils.Print;

import java.util.Arrays;
import java.util.Properties;

public class Consumer {
    public static void main(String[] args){
        try{
            Properties props=new Properties();
            props.put("bootstrap.servers","localhost:9092");
            props.put("group.id","test");
            props.put("key.deserializer",Class.forName("org.apache.kafka.common.serialization.StringDeserializer"));
            props.put("value.deserializer",Class.forName("org.apache.kafka.common.serialization.StringDeserializer"));

            KafkaConsumer<String,String>consumer=new KafkaConsumer<String, String>(props);
            consumer.subscribe(Arrays.asList("topic1"));
            while(true){
                ConsumerRecords<String,String> records=consumer.poll(1000*60*20);
                for(ConsumerRecord<String,String> record:records){
                    Print.println("key:"+record.key()+" "+",value:"+record.value());
                }
            }
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

    }
}
