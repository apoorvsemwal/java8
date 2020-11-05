package com.java8.basics;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Unit1ExcerciseJava8 {

	public static void main(String[] args) {
		
		List<Person> people = Arrays.asList(
				new Person("Apoorv", "Semwal", 28),
				new Person("Astha", "Semwal", 22),
				new Person("Jyoti Prakash", "Semwal", 59),
				new Person("Megha", "Semwal", 27),
				new Person("Rekha", "Semwal", 52)
				);
		
		//Sort list by age desc
		Collections.sort(people, (p1, p2) -> p2.getAge() - p1.getAge());
		
		//Print all
		printAll(people);

		//Print all having age greater than or equal to 30.
		//We can call the same method with some other condition next time.
		System.out.println("\n");
		printAllWithCondition(people, p -> p.getAge() >= 30);
		
		//Equivalent to printAll()
		System.out.println("\n");
		printAllWithCondition(people, p -> true);
		
		//We want that the behavior is also transferred when condition is met.
		//We use two std function interfaces - Predicate for Condition and Consumer for behavior.
		System.out.println("\n");
		performConditionally(people, p -> p.getAge() >= 30, p -> System.out.println(p));
	}

	private static void printAllWithCondition(List<Person> people, Predicate<Person> condition) {
		for (Person person : people) {
			if (condition.test(person)) {
				System.out.println(person);
			}
		}		
	}
	
	
	private static void performConditionally(List<Person> people, Predicate<Person> condition, Consumer<Person> consumer) {
		for (Person person : people) {
			if (condition.test(person)) {
				consumer.accept(person);
			}
		}		
	}
	
	private static void printAll(List<Person> people) {
		for (Person person : people) {
			System.out.println(person);
		}
	}
}