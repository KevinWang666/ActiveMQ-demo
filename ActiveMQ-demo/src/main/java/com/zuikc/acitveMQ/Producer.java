package com.zuikc.acitveMQ;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

//������

public class Producer {

	public static void main(String[] args) throws Exception {
		//���ӹ���
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.5.130:61616");
		//��������
		Connection connection = connectionFactory.createConnection();
		//��������
		connection.start();
		//�����Ự
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		//����ָ�����ƵĶ���
		Queue queue = session.createQueue("myFirstQueue");
		//����������
		MessageProducer producer = session.createProducer(queue);
		//������Ϣ
		TextMessage textMessage = session.createTextMessage("�����£���");
		//������Ϣ
		producer.send(textMessage);
		//�ͷ���Դ
		producer.close();
		session.close();
		connection.close();
	}

}
