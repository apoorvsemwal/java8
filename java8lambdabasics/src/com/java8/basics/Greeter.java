package com.java8.basics;

public class Greeter {
	public static void main(String[] args) {
		GreetingLambda myFirstGreetingLambdaExp = () -> System.out.println("Hello");
		myFirstGreetingLambdaExp.perform();
		
		
		StringLengthLambda calculateLengthLambda = (s) -> System.out.println("Length is: "+s.length());
		calculateLengthLambda.getLength("Hello");
		
		Thread t1 = new Thread(() -> System.out.println("Hello from a new thread..."));
		t1.run();
	}
}
