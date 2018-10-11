package com.demo.spring;

import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jms.core.JmsTemplate;

public class BootStrap {
public static void main(String[] args) throws JMSException {
		
	    System.out.println("Listener started");
		ApplicationContext ctx = new AnnotationConfigApplicationContext(JmsConfig.class);
		
	}
}
