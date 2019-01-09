package cn.wineyeliu.kafkademo.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;

/**
 * @author  Liu Wenai
 */
public class ProducerDemo {
    private static final String TOPIC = "test";

    public static void main(String[] args) {

        Properties props = new Properties();
        props.put("bootstrap.servers", "kafka01.lwi:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        // 创建Kafka Producer可以有多种方式 使用Properties只是其中一种
        KafkaProducer<String, String> producer = new KafkaProducer<>(props);
        // producer发送的是ProducerRecord消息对象
        ProducerRecord<String, String> record = new ProducerRecord<>(TOPIC, "aaa", "ddd");

        try {
            /***RecordMetadata recordMetadata = producer.send(record).get();*/

            // 回调方式， CallBack是函数接口，可以使用java8特性
            producer.send(record, (recordMeta, e)-> {
                if(e!=null) {
                    e.printStackTrace();
                }
                System.out.println(recordMeta);
            });
            //topic-partition@offset
            /***System.out.println(recordMetadata);*/
        } catch (Exception e) {
            e.printStackTrace();
        }

        producer.close();
    }
}
