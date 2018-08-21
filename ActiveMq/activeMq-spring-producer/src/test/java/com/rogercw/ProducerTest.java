package com.rogercw;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author: rogercw
 * @Date: 2018/8/17 19:33
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-jms-producer.xml")
public class ProducerTest {

    @Autowired
    private QueueProducer queueProducer;
    @Autowired
    private TopicProducer topicProducer;

    @Test
    public void queueProducerTest() {
        queueProducer.sendMessage("SpringJms的点对点测试");
    }


    @Test
    public void topicProducerTest() {
        topicProducer.send("SpringJms的发布订阅模式测试");
    }
}
