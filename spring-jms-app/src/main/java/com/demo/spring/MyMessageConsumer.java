package com.demo.spring;

import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jms.core.JmsTemplate;

public class MyMessageConsumer {
public static void main(String[] args) throws JMSException {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(JmsConfig.class);
		JmsTemplate jt = ctx.getBean(JmsTemplate.class);
		
		TextMessage tm = (TextMessage) jt.receive("testQueue");
		System.out.println("Message received:"+tm.getText());
	}
}
