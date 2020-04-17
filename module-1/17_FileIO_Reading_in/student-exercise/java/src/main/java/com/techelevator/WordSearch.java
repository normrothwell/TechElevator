package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordSearch {

	public static void main(String[] args) {

		int lineNumber = 0;
		boolean isCaseSensitive = false;
		String tempLine = "";
		Scanner userInput = new Scanner(System.in);
		Scanner input = null;
		System.out.println("Enter file name: ");
		String userinput = userInput.nextLine();
		File document = new File(userinput);
		try {
			input = new Scanner(document);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			System.exit(1);
		}
		System.out.println("Enter a String to be found: ");
		String findString = userInput.nextLine();

		System.out.println("Should this search be case sensitive? Enter (y)es or (n)o:");
		String caseSensitive = userInput.nextLine();
		if ((caseSensitive.equals("y") || caseSensitive.equals("Y"))) {
			isCaseSensitive = true;
		} else
			findString = findString.toLowerCase();

		while (input.hasNext()) {
			lineNumber++;
			tempLine = "";
			String line = input.nextLine();
			if (!isCaseSensitive) {
				tempLine = line.toLowerCase();
			}
			if ((line.contains(findString)) || (tempLine.contains(findString))) {
				System.out.println(lineNumber + ") " + line);

			}
		}
	}

}