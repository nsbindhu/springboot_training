package com.demo.lambda;


public class LambdaExample {
	public static void main(String[] args) {
		/*Thread t1 = new Thread(()->System.out.println("This is run method"));
		t1.start();*/
		LambdaInterface1 i1 = (s1,s2)->{return s1+"-> "+s2;};
		System.out.println(i1.printLambdaExpression("Lambda Expresssions", "Example"));
	}
}
