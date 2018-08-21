package rogercw;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @Author: rogercw
 * @Date: 2018/8/17 18:05
 * @Version 1.0
 * 点对点消费者
 */
public class QueueConsummer {

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
        //创建消息消费者
        MessageConsumer consumer = session.createConsumer(queue);

        //使用receive()方法接收消息时， 启动后不会再自动消费以后产生的消息
        //TextMessage message = (TextMessage) consumer.receive();
        //System.out.println(message.getText());

        //使用消息监听的方式来获取消息:使用这种方式时，以后生产者创建的消息会被监听到而被立即消费
        consumer.setMessageListener(new MessageListener() {
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage) message;
                try {
                    System.out.println(textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });

        //等待键盘输入
        System.in.read();

        //关闭资源
        consumer.close();
        session.close();
        connection.close();
    }
}
