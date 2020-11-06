package com.java8.basics;

public class ClosureTest {

	public static void main(String[] args) {
		int a = 10;
		doProcess(a, i -> {
			System.out.println(a + i);
			});
		//a = 20; //Would result in an error within Lambda. a is effectively final for deterministic o/p.
	}

	public static void doProcess(int a, ProcessLambda procLambda) {
		procLambda.process(a);
	}
}

