package com.zuikc.acitveMQ_Spring;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.stereotype.Component;

@Component
public class MyFirstMessageListener implements MessageListener {

	@Override
	public void onMessage(Message arg0) {
		TextMessage tm = (TextMessage)arg0;
		try {
			String text = tm.getText();
			System.out.println("SpringΩ” ’...." + text);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
