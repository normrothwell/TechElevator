package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FizzWriter {

	public static void main(String[] args) throws IOException{
		
		Scanner input = new Scanner(System.in);
		PrintWriter writer = null;
		
		
		
		
		System.out.println("Enter a name for a new file: ");
		String fileName = input.nextLine();
		File newFile = new File (fileName);
		newFile.createNewFile();
		
		try {
			writer = new PrintWriter(newFile);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		
		for (int x = 1; x<=300; x++) {	
		String numString = Integer.toString(x);
		if (((x%3 == 0) && (x%5 == 0)) || ((numString.contains("3") && numString.contains("5")))) {
			writer.println("Fizzbuzz");
		}else if ((x%3 == 0) || (numString.contains("3"))) {
			writer.println("Fizz");
		}else if ((x%5 == 0) || (numString.contains("5"))) {
			writer.println("Buzz");
		}else writer.println(Integer.toString(x));
		}
		writer.close();
		input.close();
	
	}
		
}


