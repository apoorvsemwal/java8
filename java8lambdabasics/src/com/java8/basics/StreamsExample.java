package com.java8.basics;

import java.util.Arrays;
import java.util.List;

public class StreamsExample {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList(
				new Person("Apoorv", "Semwal", 28),
				new Person("Astha", "Semwal", 22),
				new Person("Jyoti Prakash", "Semwal", 59),
				new Person("Megha", "Semwal", 27),
				new Person("Rekha", "Semwal", 52)
				);
		
		//Get a new list of people starting their first name with 'A'.
		people.stream()
		.filter(p -> p.getFirstName().startsWith("A"))
		.forEach(p-> System.out.println(p));
		
		System.out.println("\nCount");
		System.out.println(people.parallelStream()
		.filter(p -> p.getFirstName().startsWith("A"))
		.count());
	}

}
