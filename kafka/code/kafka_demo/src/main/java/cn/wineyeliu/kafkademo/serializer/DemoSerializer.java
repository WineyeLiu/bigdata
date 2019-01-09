package cn.wineyeliu.kafkademo.serializer;

import org.apache.kafka.common.serialization.Serializer;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Map;

/**
 * @author mistw
 * 如果使用自定义的对象则需要编写自定义的序列化器
 * 不过通常使用序列化框架 如Apache Avro，Thrift，Protobuf
 */
public class DemoSerializer implements Serializer<Demo> {
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public byte[] serialize(String topic, Demo data) {
        if(data != null) {
            byte[] nameBytes = data.getName().getBytes(Charset.forName("UTF-8"));
            byte[] emailBytes =  data.getEmail().getBytes(Charset.forName("UTF-8"));
            ByteBuffer bf = ByteBuffer.allocate(nameBytes.length + emailBytes.length + 4);
            bf.putInt(data.getId());
            bf.put(nameBytes);
            bf.put(emailBytes);

            return bf.array();
        }

        return null;
}

    @Override
    public void close() {

    }
}
