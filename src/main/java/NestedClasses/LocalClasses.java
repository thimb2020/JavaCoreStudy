package NestedClasses;

/*
 * You can define a local class inside any block (see Expressions, Statements, and Blocks for more information)
 *  You typically find local classes defined in the body of a method.
 */
public class LocalClasses {
	static String regularExpression = "[^0-9]";

	public static void validatePhoneNumber(String phoneNumber1, String phoneNumber2) {

		final int numberLength = 10; // a local class can only access local variables that are declared final

		/*
		 * Local classes are similar to inner classes because they cannot define or
		 * declare any static members Local classes in static methods,can only refer to
		 * static members of the enclosing class. You cannot declare static initializers
		 * or member interfaces in a local class. A local class can have static members
		 * provided that they are constant variables
		 */
		class PhoneNumber {
			public static final String farewell = "Bye bye";
			String formattedPhoneNumber = null;

			PhoneNumber(String phoneNumber) {
				String currentNumber = phoneNumber.replaceAll(regularExpression, "");
				if (currentNumber.length() == numberLength)
					formattedPhoneNumber = currentNumber;
				else
					formattedPhoneNumber = null;
			}

			public String getNumber() {
				return formattedPhoneNumber;
			}

		}

		PhoneNumber myNumber1 = new PhoneNumber(phoneNumber1);
		PhoneNumber myNumber2 = new PhoneNumber(phoneNumber2);

		if (myNumber1.getNumber() == null)
			System.out.println("First number is invalid");
		else
			System.out.println("First number is " + myNumber1.getNumber());
		if (myNumber2.getNumber() == null)
			System.out.println("Second number is invalid");
		else
			System.out.println("Second number is " + myNumber2.getNumber());

	}

	public static void main(String... args) {
		validatePhoneNumber("123-456-7890", "456-7890");
	}
}
