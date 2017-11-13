package com.zuikc.acitveMQ;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Consumer {

	public static void main(String[] args) throws Exception {
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.5.130:61616");
		Connection connection = connectionFactory.createConnection();
		connection.start();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Queue queue = session.createQueue("myFirstQueue");
		MessageConsumer consumer = session.createConsumer(queue);
		consumer.setMessageListener(new MessageListener() {
			@Override
			public void onMessage(Message arg0) {
				TextMessage tm = (TextMessage) arg0;
				try {
					String text = tm.getText();
					System.out.println(text);
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		});

		System.out.println("°´¼üÍË³ö");
		System.in.read();
		consumer.close();
		session.close();
		connection.close();

	}

}
