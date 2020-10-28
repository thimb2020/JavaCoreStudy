package NestedClasses;

/*
 *  An anonymous class is an expression
 *  Anonymous classes are ideal for implementing an interface that contains two or more methods
 */
public class AnonymousClasses {

	interface HelloWorld {
		public void greet();

		public void greetSomeone(String someone);
	}

	public void sayHello() {

		class EnglishGreeting implements HelloWorld {
			String name = "world";

			public EnglishGreeting(String name) {
				this.name = name;
			}

			public void greet() {
				greetSomeone("world");
			}

			public void greetSomeone(String someone) {
				name = someone;
				System.out.println("Hello " + name);
			}
		}

		HelloWorld englishGreeting = new EnglishGreeting("world");

		// The syntax of an anonymous class expression is like the invocation of a
		// constructor
		// An anonymous class cannot access local variables in its enclosing scope that
		// are not declared as final or effectively final.
		// you cannot declare constructors in an anonymous class.
		HelloWorld frenchGreeting = new HelloWorld() {
			String name = "tout le monde";

			public void greet() {
				greetSomeone("tout le monde");
			}

			public void greetSomeone(String someone) {
				name = someone;
				System.out.println("Salut " + name);
			}
		};

		HelloWorld spanishGreeting = new HelloWorld() {
			String name = "mundo";

			public void greet() {
				greetSomeone("mundo");
			}

			public void greetSomeone(String someone) {
				name = someone;
				System.out.println("Hola, " + name);
			}
		};

		HelloWorld englishGreeting2 = new EnglishGreeting("abhc") {
			String name = "mundo";

			public void greet() {
				greetSomeone("mundo");
			}

			public void greetSomeone(String someone) {
				name = someone;
				System.out.println("Hola, " + name);
			}
		};
		englishGreeting.greet();
		frenchGreeting.greetSomeone("Fred");
		spanishGreeting.greet();
		englishGreeting2.greet();
	}

	public static void main(String... args) {
		AnonymousClasses myApp = new AnonymousClasses();
		myApp.sayHello();
	}
}