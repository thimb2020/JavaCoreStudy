package NestedClasses;

/*
 * A nested class is a member of its enclosing class
 * If a class is useful to only one other class, then it is logical to embed it in that class and keep the two together
 * It increases encapsulation
 * It can lead to more readable and maintainable code
 */
class NestedClasses {
	private static final int SIZE = 3; // member variable
	private int x; // member variable

	static class StaticNestedClass {

		public void accessField() {
			int test = SIZE; // access static field
		}
	}

	// It cannot define any static members itself
	class InnerClass {
		private int x = 1;
		public void accessField() {
			int test = x; // access non-static field
		}
		
		//Shadowing
        void methodInFirstLevel(int x) {
            System.out.println("x = " + x);
            System.out.println("this.x = " + this.x);
            System.out.println("ShadowTest.this.x = " + NestedClasses.this.x);
        }		
	}

	/*
	 * Create StaticNestedClass object
	 */
	public void createStaticNestedClass() {
		NestedClasses.StaticNestedClass nestedObject = new NestedClasses.StaticNestedClass();
	}

	/*
	 * Create InnnerClass object
	 */

	public void createInnerClass() {
		NestedClasses.InnerClass innerClass = new NestedClasses().new InnerClass();
	}

}
