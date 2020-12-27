package com.huofei.kafka.helloworld;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * description:
 * date: 2020/12/20 19:47
 * author: huofei
 * version: 1.0
 */
@Component
public class KafkaConsumer {
    // 消费监听
    @KafkaListener(topics = {"topic2"})
    public void onMessage1(ConsumerRecord<?, ?> record) {
        // 消费的哪个topic、partition的消息,打印出消息内容
        System.out.println("简单消费：" + record.topic() + "-" + record.partition() + "-" + record.value());
    }
//        /**
//         * @return void
//         * @Title 指定topic、partition、offset消费
//         * @Description 同时监听topic1和topic2，监听topic1的0号分区、topic2的 "0号和1号" 分区，指向1号分区的offset初始值为8
//         **/
//        @KafkaListener(id = "consumer1", groupId = "felix-group", topicPartitions = {
//                @TopicPartition(topic = "topic1", partitions = {"0"}),
//                @TopicPartition(topic = "topic2", partitions = "0", partitionOffsets = @PartitionOffset(partition = "1", initialOffset = "8"))
//        })
//        public void onMessage2 (ConsumerRecord < ?, ?>record){
//            System.out.println("topic:" + record.topic() + "|partition:" + record.partition() + "|offset:" + record.offset() + "|value:" + record.value());
//
//        }
//
//        //批量消費，设置application.prpertise开启批量消费即可，接收消息时用List来接收
//        @KafkaListener(id = "consumer2", groupId = "felix-group", topics = "topic1")
//        public void onMessage3 (List < ConsumerRecord < ?, ?>>records){
//            System.out.println(">>>批量消费一次，records.size()=" + records.size());
//            for (ConsumerRecord<?, ?> record : records) {
//                System.out.println(record.value());
//            }
//        }
//
//
//    // 新建一个异常处理器，用@Bean注入
//    // 将这个异常处理器的BeanName放到@KafkaListener注解的errorHandler属性里面
//    @KafkaListener(topics = {"topic1"},errorHandler = "consumerAwareErrorHandler")
//    public void onMessage4(ConsumerRecord<?, ?> record) throws Exception {
//
//        throw new Exception("简单消费-模拟异常");
//    }
//
//
//    // 批量消费也一样，异常处理器的message.getPayload()也可以拿到各条消息的信息
//    @KafkaListener(topics = "topic1",errorHandler="consumerAwareErrorHandler")
//    public void onMessage5(List<ConsumerRecord<?, ?>> records) throws Exception {
//        System.out.println("批量消费一次...");
//        throw new Exception("批量消费-模拟异常");
//    }

    /**
     * @Title 消息转发(to do)
     * @return void
     **/
    @KafkaListener(topics = {"topic1"})
    @SendTo("topic2")
    public String onMessage7(ConsumerRecord<?, ?> record) {
        return record.value()+"-forward message";
    }
    }
