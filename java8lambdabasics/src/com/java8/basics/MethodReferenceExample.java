package com.java8.basics;

import java.util.function.BiFunction;

public class MethodReferenceExample {

	public static void main(String[] args) {
		
		Thread t1 = new Thread(() -> printMsg());
		t1.start();
		
		//Same as above just using method reference
		Thread t2 = new Thread(MethodReferenceExample::printMsg);
		t2.start();

		MethodReferenceExample obj = new MethodReferenceExample();
		
		Runnable r1 = () -> obj.sayHi();
		r1.run();
		
		//Same as above just using method reference
		Runnable r2 = obj::sayHi;
		r2.run();
		
		BiFunction<Integer, Integer, Integer> mulFunc1 = (a,b) -> obj.multiply(a,b);
		System.out.println(mulFunc1.apply(10, 20));
		
		//Same as above just using method reference. In method references we need not worry about 
		//parameters as compiler checks them on the basis of interface method signature. 
		//Here apply accepts two integers and returns an integer.
		BiFunction<Integer, Integer, Integer> mulFunc2 = obj::multiply;
		System.out.println(mulFunc2.apply(10, 20));
		
	}
	
	private void sayHi() {
		System.out.println("Hello");
	}
	
	private static void printMsg() {
		System.out.println("Hello");
	}

	private int multiply(int a, int b) {
		return a*b;
	}
}
