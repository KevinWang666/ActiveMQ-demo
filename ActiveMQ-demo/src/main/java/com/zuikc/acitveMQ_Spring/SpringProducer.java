package com.zuikc.acitveMQ_Spring;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class SpringProducer {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-activeMQ.xml");
		JmsTemplate jmsTemplate = (JmsTemplate) context.getBean("jmsTemplate");
		jmsTemplate.send(new MessageCreator() {

			@Override
			public Message createMessage(Session arg0) throws JMSException {
				TextMessage textMessage = arg0.createTextMessage("Spring发送消息....配置默认目标:   " + "CupHead!");
				return textMessage;
			}
		});
	}

}
