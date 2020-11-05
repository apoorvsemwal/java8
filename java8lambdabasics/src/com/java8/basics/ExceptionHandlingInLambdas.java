package com.java8.basics;

import java.util.function.BiConsumer;

public class ExceptionHandlingInLambdas {

	public static void main(String[] args) {
		int[] someNumbers = {1,2,3,4,5};
		int key = 2;
		//Apply key to each number in array and do this using lambda
		process(someNumbers, key, (v, k) -> System.out.println(v + k));
		
		//New behavior which might give divide by zero error.
		//But code looks messy
		key = 0;
		process(someNumbers, key, (v, k) -> {
			try {
				System.out.println(v / k);
			} catch (Exception e) {
				System.out.println("Dividing by zero error...");
			}
		});
		
		
		//Wrap lambda within lambda for better readability of code. No try catch here...
		process(someNumbers, key, wrappedLambda((v, k) -> System.out.println(v / k)));		

	}

	private static BiConsumer<Integer, Integer> wrappedLambda(BiConsumer<Integer, Integer> consumer) {
		return (v,k) -> {
			try {
				consumer.accept(v, k);
			} catch (Exception e) {
				System.out.println("Exception in wrapped lambda...");
			}
		};
	}

	private static void process(int[] someNumbers, int key, BiConsumer<Integer, Integer> consumer) {
		for (int i : someNumbers) {
			consumer.accept(i, key);
		}
		
	}
	
	

}
