package com.ami.activity.stream;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

/**
 * @author wangchendong
 * @date 2021/05/20
 */
public class StreamTest {

    private static final String EXCHANGE_NAME = "xxx";

    private static final String QUEUE_NAME = "xxx";

    public static void main(String[] args) throws IOException, TimeoutException {
        // 获取到连接以及mq通道
        ConnectionFactory connectionFactory = new ConnectionFactory();
        //设置连接地址
        connectionFactory.setHost("xxx");
        //设置端口
        connectionFactory.setPort(1111);
        //设置密码用户名
        connectionFactory.setUsername("xxxx");
        connectionFactory.setPassword("xxxx");
        //设置虚拟机,每个虚拟机相当于一个小的mq
        connectionFactory.setVirtualHost("/");
        // 设置服务端的地址、端口、用户名和密码...
        Connection connection = connectionFactory.newConnection();
        final Channel channel = connection.createChannel();

        // 声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        // 绑定队列到交换机
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "*.xxx");
        //------------下面逻辑和work模式一样-----
        // 同一时刻服务器只会发一条消息给消费者
        channel.basicQos(1);

        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                // 消息到达 触发这个方法
                String msg = new String(body, StandardCharsets.UTF_8);
                System.out.println("[xxx]:" + msg);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("xxx消息执行完毕！");
                    // 手动回执
                    channel.basicAck(envelope.getDeliveryTag(), false);
                }
            }
        };

        boolean autoAck = false;
        channel.basicConsume(QUEUE_NAME, autoAck, consumer);
    }
}
