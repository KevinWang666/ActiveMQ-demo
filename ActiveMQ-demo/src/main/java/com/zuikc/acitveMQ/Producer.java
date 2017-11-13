package com.zuikc.acitveMQ;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

//发布者

public class Producer {

	public static void main(String[] args) throws Exception {
		//连接工厂
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.5.130:61616");
		//创建连接
		Connection connection = connectionFactory.createConnection();
		//启动连接
		connection.start();
		//创建会话
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		//创建指定名称的队列
		Queue queue = session.createQueue("myFirstQueue");
		//创建发布者
		MessageProducer producer = session.createProducer(queue);
		//创建消息
		TextMessage textMessage = session.createTextMessage("金马寺？？");
		//发送消息
		producer.send(textMessage);
		//释放资源
		producer.close();
		session.close();
		connection.close();
	}

}
