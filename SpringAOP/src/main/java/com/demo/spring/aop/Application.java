package com.demo.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.spring.aop.perform.Performer;
import com.demo.spring.aop.perform.Singer;

public class Application {
	public static void main(String[] args) {
		ApplicationContext ctx= new AnnotationConfigApplicationContext(AopConfig.class);
		Performer sing = (Performer)ctx.getBean("singer");
		//Singer sing = ctx.getBean(Singer.class);
		sing.perform();
	}
}
