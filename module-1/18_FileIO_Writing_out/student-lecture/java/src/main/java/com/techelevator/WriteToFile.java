package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class WriteToFile {

	public static void main(String[] args)  {
		
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter file name to write to: ");
		String fileName = input.nextLine();
		
		File file = new File (fileName);
		PrintWriter writer = null;
		
		try {
			writer = new PrintWriter(file);
		} catch (FileNotFoundException e) {
			System.out.println("File cannot be written to");
			e.printStackTrace();
			System.exit(0);
		}
		
		
		for (int x=0;x<3;x++) {
			System.out.println("Enter employee name: ");
			String name = input.nextLine();
			System.out.println("Enter number of hours worked: ");
			int hours = Integer.parseInt(input.nextLine());
			System.out.println("Enter rate of pay: ");
			double rate = Double.parseDouble(input.nextLine());
			double salary = rate * hours;
			writer.printf("%-30s %6d %8.2f %8.2f\n", name, hours, rate, salary);
		}
		writer.close();

	}

}
