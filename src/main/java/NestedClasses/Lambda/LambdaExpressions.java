package NestedClasses.Lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class LambdaExpressions {
	/*
	 * Approach 1: Create Methods That Search for Members That Match One
	 * Characteristic
	 */
	public static void printPersonsOlderThan(List<Person> roster, int age) {
		for (Person p : roster) {
			if (p.getAge() >= age) {
				p.printPerson();
			}
		}
	}

	/*
	 * Approach 2: Create More Generalized Search Methods
	 */
	public static void printPersonsWithinAgeRange(List<Person> roster, int low, int high) {
		for (Person p : roster) {
			if (low <= p.getAge() && p.getAge() < high) {
				p.printPerson();
			}
		}
	}

	/*
	 * Approach 3: Specify Search Criteria Code in a Local Class
	 */
	public static void printPersons(List<Person> roster, CheckPerson tester) {
		for (Person p : roster) {
			if (tester.test(p)) {
				p.printPerson();
			}
		}
	}

	interface CheckPerson {
		boolean test(Person p);
	}

	class CheckPersonEligibleForSelectiveService implements CheckPerson {
		public boolean test(Person p) {
			return p.gender == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25;
		}
	}

	public static void printPersonsWithPredicate(List<Person> roster, Predicate<Person> tester) {
		for (Person p : roster) {
			if (tester.test(p)) {
				p.printPerson();
			}
		}
	}

	public static void main(String[] args) {
		List<Person> roster = new ArrayList<Person>();
		// Approach 3: Specify Search Criteria Code in a Local Class
		printPersons(roster, new LambdaExpressions().new CheckPersonEligibleForSelectiveService());

		// Approach 4: Specify Search Criteria Code in an Anonymous Class
		printPersons(roster, new CheckPerson() {
			public boolean test(Person p) {
				return p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25;
			}
		});
		// Approach 5: Specify Search Criteria Code with a Lambda Expression (functional
		// interface - interface that contains only one abstract method)
		printPersons(roster, (Person p) -> p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25);

		// Approach 6: Use Standard Functional Interfaces with Lambda Expressions (JDK
		// defines several standard functional interfaces)
		printPersonsWithPredicate(roster,
				p -> p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25);
	}
}
