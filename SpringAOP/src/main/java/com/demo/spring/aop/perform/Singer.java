package com.demo.spring.aop.perform;

import org.springframework.stereotype.Service;


@Service
public class Singer implements Performer {
	
	public void perform() {
		//audience.takeSeat();
		//audience.switchOffMobile();
		System.out.println("Singer is singing ...");
		//audience.appluad();
	}

}
