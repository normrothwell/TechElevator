package com.techelevator;

public class Lecture {

	public static void main(String[] args) { // method
		// a line comment starts with two forward slashes
		/*
		 * this is a block comment
		 */
		/*
		1. Create a variable to hold an int and call it numberOfExercises.
			Then set it to 26.
		*/
		int numberOfExercises;
		numberOfExercises = 26;
		System.out.println(numberOfExercises);

		/*
		2. Create a variable to hold a double and call it half.
			Set it to 0.5.
		*/
		double half = 0.5;
		System.out.println(half);

		/*
		3. Create a variable to hold a String and call it name.
			Set it to "TechElevator".
		*/
		String name = "Tech Elevator"; // inside the quotes is called a string literal
		System.out.println(name);

		/*
		4. Create a variable called seasonsOfFirefly and set it to 1.
		*/
		int seasonsOfFirefly = 1;
		System.out.println(seasonsOfFirefly);

		/*
		5. Create a variable called myFavoriteLanguage and set it to "Java".
		*/
		String myFavoriteLanguage = "Java";
		System.out.println(myFavoriteLanguage);

		/*
		6. Create a variable called pi and set it to 3.1416.
		*/
		double pi = 3.1416;
		System.out.println(pi);

		/*
		7. Create and set a variable that holds your name.
		*/
		String myName = "Margaret Green";
		System.out.println(myName);
		/*
		8. Create and set a variable that holds the number of buttons on your mouse.
		*/
		int numberOfButtonsOnMouse = 3;
		System.out.println(numberOfButtonsOnMouse);

		/*
		9. Create and set a variable that holds the percentage of battery left on
		your phone.
		*/
		double percentBatteryLeft = 0.84;
		
		System.out.println(percentBatteryLeft);

		/*
		10. Create an int variable that holds the difference between 121 and 27.
		*/

		int num1 = 121;
		int num2 = 27;
		int difference = num1 - num2;
		
		System.out.println(difference);
		/*
		11. Create a double that holds the addition of 12.3 and 32.1.
		*/
		double add1 = 12.3;
		double add2 = 32.1;
		double addition = add1 + add2;
		System.out.println(addition);
		System.out.printf("%6.2f\n", addition); // %6 is format width specifier , .2 says only display 2 decimal points to the right of the decimal point
		// notice also it uses a comma instead of a + to separate between the variable and the format
		// \n is the escape sequence for a new line
		
		/*
		12. Create a String that holds your full name.
		*/
		String myFullName = "Margaret Lane Green";
		System.out.println(myFullName);
		/*
		13. Create a String that holds the word "Hello, " concatenated onto your
		name from above.
		*/
		String greeting = "Hello, " + myFullName;
		System.out.println(greeting);
		/*
		14. Add a " Esquire" onto the end of your full name and save it back to
		the same variable.
		*/
		greeting = greeting + " Esquire";  
		System.out.println(greeting);

		/*
		15. Now do the same as exercise 14, but use the += operator.
		*/
		greeting += " Esquire";
		System.out.println(greeting);

		/*
		16. Create a variable to hold "Saw" and add a 2 onto the end of it.
		*/
		String movie = "Saw";
		System.out.println(movie + 2);

		/*
		17. Add a 0 onto the end of the variable from exercise 16.
		*/

		System.out.println(movie + " 2" + 0);
		/*
		18. What is 4.4 divided by 2.2?
		*/

		double n1 = 4.4;
		double n2 = 2.2;
		double answer = n1 / n2;
		System.out.println(answer);
		/*
		19. What is 5.4 divided by 2?
		*/
		n1 = 5.4;
		n2 = 2;
		answer = n1 / n2;
		System.out.println(answer);
		/*
		20. What is 5 divided by 2?
		*/
		System.out.println(5 / 2);
		/*
		21. What is 5.0 divided by 2?
		*/
		System.out.println(5.0 / 2);
		/*
		22. What is 66.6 divided by 100? Is the answer you get right or wrong?
		*/
		System.out.println(66.6 / 100);
		System.out.printf("%.2f\n", 66.6 / 100);  // when you use the print format, it rounds!  \n to move down a line
		
		/*
		23. If I divide 5 by 2, what's my remainder?
		*/
		System.out.println(5 % 2);

		/*
		24. What is 1,000,000,000 * 3?
		*/
		long ans = (long)1000000000 * 3; //one number needs an l on the end or cast one number to a long
		System.out.println(ans);
		/*
		25. Create a variable that holds a boolean called doneWithExercises and
		set it to false.
		*/
		
		boolean doneWithExercises = false;
		System.out.println(doneWithExercises);

		/*
		26. Now set doneWithExercise to true.
		*/
		doneWithExercises = true;
		System.out.println(doneWithExercises);
		
	}

}
