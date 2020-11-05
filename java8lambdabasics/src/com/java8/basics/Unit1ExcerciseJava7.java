package com.java8.basics;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Unit1ExcerciseJava7 {

	public static void main(String[] args) {
		
		List<Person> people = Arrays.asList(
				new Person("Apoorv", "Semwal", 28),
				new Person("Astha", "Semwal", 22),
				new Person("Jyoti Prakash", "Semwal", 59),
				new Person("Megha", "Semwal", 27),
				new Person("Rekha", "Semwal", 52)
				);
		
		//Sort list by age desc
		Collections.sort(people, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return (o2.getAge() - o1.getAge());
			}
		});
		
		//Print all
		printAll(people);

		//Print all having age greater than or equal to 30.
		//We can call the same method with some other condition next time.
		System.out.println("\n");
		printAllWithCondition(people, new ConditionLambda() {
			@Override
			public boolean test(Person p) {
				return p.getAge() >= 30;
			}
		});
		
		//Equivalent to printAll()
		System.out.println("\n");
		printAllWithCondition(people, new ConditionLambda() {
			@Override
			public boolean test(Person p) {
				return true;
			}
		});
	}

	private static void printAllWithCondition(List<Person> people, ConditionLambda condition) {
		for (Person person : people) {
			if (condition.test(person)) {
				System.out.println(person);
			}
		}		
	}

	private static void printAll(List<Person> people) {
		for (Person person : people) {
			System.out.println(person);
		}
	}
}