package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class WriteToFile {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println("Enter the file name to write to: ");
		String fileName = input.nextLine();

		File file = new File(fileName);
		PrintWriter writer = null;

		try {
			writer = new PrintWriter(file);
		} catch (FileNotFoundException e) {
			// handle the error from trying to open a PrintWriter object
			System.out.println("File cannot be written to");
			e.printStackTrace();
			System.exit(0);
		}

		writer.println("Employee Name                Hours       Rate    Salary");
		writer.println("=======================================================");
		// ask the user for input
		for (int i = 0; i < 3; i++) {
			System.out.println("Enter employee name: ");
			String name = input.nextLine();
			System.out.println("Enter number of hours worked: ");
			int hours = Integer.parseInt(input.nextLine());
			System.out.println("Enter rate of pay: ");
			double rate = Double.parseDouble(input.nextLine());
			double salary = hours * rate;

			// then write to the file down here
			writer.printf("%-25s  %6d %8.2f  %8.2f\n", name, hours, rate, salary);
			// s = string, d = digit (int)  f = float (double)
		}
		// close the file!
		writer.close();

		// if we wanted to append, ony way would be to use a FileWriter object
		// instead of a File object
		/*
		 * public static void main(String[] args) {
		 * 
		 * Scanner input = new Scanner (System.in);
		 * 
		 * System.out.println("Enter the file name to write to: "); String fileName =
		 * input.nextLine(); FileWriter file = null; **** Create outside of the try
		 * block PrintWriter writer = null;
		 * 
		 * try { file = new FileWriter(fileName, true); // using a FileWriter // true
		 * means we will append writer = new PrintWriter(file);
		 */
	}

}
