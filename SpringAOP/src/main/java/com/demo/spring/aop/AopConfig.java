package com.demo.spring.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages="com.demo.spring.aop")
@EnableAspectJAutoProxy
public class AopConfig {

}
