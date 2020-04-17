package com.techelevator.scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReadDemo {

	@SuppressWarnings("resource") // this makes it so I don't have to close my resources -- they
	// will automatically be closed when the application ends.
	public static void main(String[] args) throws FileNotFoundException {

		Scanner input = new Scanner(System.in);
		System.out.println("Enter the file name: ");
		String strFileName = input.nextLine();
		File file = new File(strFileName);
		
		Scanner fileInput = new Scanner(file); // we can either add a throws declaraion on this method
		// or surround with a try catch block for the FileNotFoundException
		while (fileInput.hasNextLine()) {
			String line = fileInput.nextLine();
			System.out.println(line);
		}

	}

}
