package rogercw;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @Author: rogercw
 * @Date: 2018/8/17 17:46
 * @Version 1.0
 * 点对点生产者
 */
public class QueueProducer {

    public static void main(String[] args) throws Exception {
        //创建连接工厂
        ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://192.168.25.103:61616");
        //创建连接
        Connection connection = factory.createConnection();
        //启动连接
        connection.start();
        //创建会话:参数1：是否启动事物，参数2：消息确认模式
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //创建队列对象
        Queue queue = session.createQueue("test-queue");
        //创建消息生产者
        MessageProducer producer = session.createProducer(queue);
        //创建消息对象
        Message message = session.createTextMessage("点对点消息测试");
        //发送消息
        producer.send(message);
        //关闭资源
        producer.close();
        session.close();
        connection.close();

    }
}
