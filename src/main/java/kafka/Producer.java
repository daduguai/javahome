package kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class Producer {

    public static void main(String[] args){
        //configuration
        Properties props=new Properties();
        //server address
        props.put("bootstrap.servers","localhost:9092");
        props.put("key.serializer", StringSerializer.class);
        props.put("value.serializer",StringSerializer.class);

        //创建生产者实例
        KafkaProducer<String,String>producer=new KafkaProducer<String,String>(props);
        ProducerRecord record=new ProducerRecord<String,String>("topic1","userName","lc");

        producer.send(record);
        producer.close();
    }
}
