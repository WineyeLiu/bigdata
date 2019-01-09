package cn.wineyeliu.kafkademo.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Collections;
import java.util.Date;
import java.util.Properties;

public class ConsumerDemo {
    private static final String TOPIC = "test";
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "kafka01.lwi:9092");
        props.put("group.id", "test");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        // 创建一个消费者
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);
        consumer.subscribe(Collections.singletonList(TOPIC));

        try {
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
                for (ConsumerRecord<String, String> record: records) {
                    System.out.println(new Date());
                    System.out.println(record);
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            consumer.close();
        }
    }
}
