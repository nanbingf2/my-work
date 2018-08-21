package rogercw;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @Author: rogercw
 * @Date: 2018/8/17 18:27
 * @Version 1.0
 * 发布订阅模式生产者
 */
public class TopicProducer {

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://192.168.25.103:61616");
        Connection connection = factory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic("test-topic");
        MessageProducer producer = session.createProducer(topic);
        TextMessage message = session.createTextMessage("发布订阅模式测试");
        producer.send(message);
        producer.close();
        session.close();
        connection.close();
    }
}
