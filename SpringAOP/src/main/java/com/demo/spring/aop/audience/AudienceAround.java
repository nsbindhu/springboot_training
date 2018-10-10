package com.demo.spring.aop.audience;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Component
@Aspect
@Order(1)
public class AudienceAround {
	@Pointcut("execution(* com.demo.spring.aop.perform.Performer.perform(..))")
	public void pcut() {
		
	}
	@Before("pcut()")
	public void buyTicket() {
		System.out.println("Audience buying tickets...");
	}
	@After("pcut()")
	public void exitShow() {
		System.out.println("Show is ended..audience leaving the show");
	}
	@Around("pcut()")
	public void callAround(ProceedingJoinPoint pjp) throws Throwable {
	//	buyTicket();
		pjp.proceed();
	//	exitShow();
	}
}
