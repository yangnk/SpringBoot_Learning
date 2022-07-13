package com.yangnk.kafka;

import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import kafka.producer.KeyedMessage;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.RecordMetadata;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2022-04-16 10:21
 **/
public class HelloWorldProducer {
    public static void main(String[] args) {
//    long events = Long.parseLong(args[0]);
        long events = 30;
        Random rnd = new Random();

        Properties props = new Properties();
        props.put("bootstrap.servers", "127.0.0.1:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        //配置partitionner选择策略，可选配置
//    props.put("partitioner.class", "SimplePartitioner2");
        props.put("message.timeout.ms", "3000");

        Producer<String, String> producer = new KafkaProducer<>(props);

        String topic = "hello_topic";

        for (long nEvents = 0; nEvents < events; nEvents++) {
            long runtime = new Date().getTime();
            String ip = "192.168.2." + rnd.nextInt(255);
            String msg = runtime + ",www.example.com," + ip;
            System.out.println(msg);
            ProducerRecord<String, String> data = new ProducerRecord<String, String>(topic, ip, msg);
            producer.send(data, new Callback() {
                public void onCompletion(RecordMetadata metadata, Exception e) {
                    if (e != null) {
                        e.printStackTrace();
                    } else {
                        System.out.println("The offset of the record we just sent is: " + metadata.offset());
                    }
                }
            });
        }
        System.out.println("send message done");
        producer.close();
        System.exit(-1);
    }
}
