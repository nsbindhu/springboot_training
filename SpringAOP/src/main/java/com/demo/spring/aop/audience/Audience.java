package com.demo.spring.aop.audience;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Audience {

	@Before("execution(* com.demo.spring.aop.perform.Performer.perform(..))")
	public void takeSeat() {
		System.out.println("Audience taking seats...");
	}
	@Before("execution(* com.demo.spring.aop.perform.Performer.perform(..))")
	public void switchOffMobile() {
		System.out.println("Audience swiching off mobiles...");
	}
	@AfterReturning("execution(* com.demo.spring.aop.perform.Performer.perform(..))")
	public void appluad() {
		System.out.println("Audience applauding singer...Clap!Clap!Clap!");
	}
}
